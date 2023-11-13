package com.example.juegocartamasalta

class Carta (val nombre: Naipes, val palo : Palos, var puntosMin: Int, var puntosMax: Int, var idDrawable:Int){
    init {
        if (nombre.valor == 1){
            puntosMax = 11
            puntosMin = 1
        }else if(nombre.valor in 2 ..11){
            puntosMax = nombre.valor
            puntosMin = nombre.valor
        }else if(nombre.valor > 10){
            puntosMax = 10
            puntosMin = 10
        }
        idDrawable = nombre.valor + (palo.valor * 13)
    }
}