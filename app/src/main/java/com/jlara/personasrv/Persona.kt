package com.jlara.personasrv

data class Persona(
    val nombre: String,
    val descripcion: String,
    val imagen: Int,
    val anioNacimiento: Int,
    val email: String,
    val telefono: String,
    val ciudad: String,
)
