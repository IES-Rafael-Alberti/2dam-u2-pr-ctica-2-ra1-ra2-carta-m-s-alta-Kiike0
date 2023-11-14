package com.example.juegocartamasalta

class Baraja {
    companion object {
        private var listaCartas: ArrayList<Carta> = arrayListOf()
        private var tamano = 0
        init {
            crearBaraja()
            barajar()
        }

        fun crearBaraja() {
            for (palo in Palos.values()) {
                for (naipe in Naipes.values()) {
                    listaCartas.add(Carta(naipe, palo, 0, 0, 0))
                }
            }
            tamano = listaCartas.size
        }

        fun barajar() {
            listaCartas.shuffle()
        }

        fun dameCarta(): Carta? {
            if (listaCartas.size>0) {
                val cartaTemp = listaCartas.last()
                listaCartas.remove(cartaTemp)
                tamano = listaCartas.size
                return cartaTemp
            }
            return null

        }
    }
}