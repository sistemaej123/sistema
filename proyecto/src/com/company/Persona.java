package com.company;

public class Persona {
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }
    public int getEdad() {
        return this.edad;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Ejemplo método con el que usar @Override en Empleado.java
    public boolean puedeTrabajar() {
        return false;
    }
}
