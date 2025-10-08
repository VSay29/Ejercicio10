package com.example.kotlintestapp

open class Empleado(val nombre: String, var sueldo: Double) {

    open fun mostrarDetalles(): String {
        return "Nombre: $nombre\nSueldo: $sueldo"
    }

}