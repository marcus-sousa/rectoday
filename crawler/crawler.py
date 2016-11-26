import requests
from pymongo import MongoClient
from json import dumps
import xmltodict
import json

client = MongoClient()


class DataImport(object):
    @property
    def db(self):
        return client.climatempo

    def execute(self, first, last):
        print 'Init delete database'
        self.db.cities.drop()
        print 'End delete database'

        print 'Init Import JOB...'
        for codeCity in range(first, last):
            URL = "http://servicos.cptec.inpe.br/XML/cidade/7dias/%s/previsao.xml" % codeCity
            response = requests.get(URL)
            element = xmltodict.parse(response.text)
            if element.get('cidade').get('nome') != 'null':
                new_obj = json.loads(dumps(element.get('cidade')))
                new_obj.update({'_id': codeCity})
                self.db.cities.insert(new_obj)
        print 'End Import JOB'

dataImport = DataImport()
dataImport.execute(0, 8600)