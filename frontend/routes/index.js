var express = require('express'),
    router = express.Router(),
    City = require('../models/city.js');

router.get('/', function (req, res, next) {

    City.find({}, {"previsao": 0}, function (err, citiesNames) {
        if (err) throw err;
        res.render('index', {citiesNames: citiesNames});
    });

});

module.exports = router;
