package com.example.juegocartamasalta

class Baraja {
    companion object {
        private var listaCartas: MutableList<Carta> = mutableListOf()
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
        }

        fun barajar() {
            listaCartas.shuffle()
        }

        fun dameCarta(): Carta? {
            return if (listaCartas.isNotEmpty()) {
                listaCartas.removeAt(listaCartas.size - 1)
            } else {
                null
            }
        }
    }
}