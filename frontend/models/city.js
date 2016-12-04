/**
 *  @author marcussousa.
 *  @since  12/2/16.
 */
var mongoose = require('mongoose');
    mongoose.connect('mongodb://localhost/climatempo');
var Schema = mongoose.Schema;

var PrevisaoSchema = new Schema({
    minima : Number,
    iuv: String,
    tempo: String,
    dia: Date,
    maxima: Number
}),
    CitySchema = new Schema({
    nome: String,
    uf: String,
    atualizacao : Date,
    previsao: [PrevisaoSchema]
});

var City = mongoose.model('City', CitySchema);

module.exports = City;