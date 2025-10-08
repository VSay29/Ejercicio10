package com.example.kotlintestapp

class Gerente(var bono: Double) : Empleado("Juan", 2000.0) {

    override fun mostrarDetalles(): String {
       return super.mostrarDetalles() + "\nBono: $bono"
    }

}