package com.example.aplicacionbicicletas

class Bicicletas {
    var modelo: String
    var empresa: String
    var año: Int
    var imagen: String
    var precio: Int


    constructor(modelo: String, empresa: String, precio: Int, año: Int, imagen: String) {
        this.modelo = modelo
        this.empresa = empresa
        this.año = año
        this.imagen = imagen
        this.precio = precio


    }

}