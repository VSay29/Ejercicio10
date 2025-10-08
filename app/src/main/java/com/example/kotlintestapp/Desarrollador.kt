package com.example.kotlintestapp

class Desarrollador(var lenguaje: String) : Empleado("Ana", 1500.0) {

    override fun mostrarDetalles(): String {
        return super.mostrarDetalles() + "\nLenguaje: $lenguaje"
    }
    
}