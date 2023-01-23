package com.iesmurgi.secretariamurgi_pablo

data class Ciclos(val Nombre:String){

    companion object{

        val androidSource = listOf(
            Ciclos ("Seleccione una Familia"),
            Ciclos ("Informática y comunicaciones"),
            Ciclos ("Transporte y mantenimiento de vehiculos"),
            )

    }

    override fun toString(): String {
        return Nombre
    }


}