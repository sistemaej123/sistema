package com.company;

public class Empleado extends Persona {
    private String cuit;

    // Constructor
    public Empleado(String nombre, int dni, String cuit) {
        super(nombre, dni);
        this.cuit = cuit;
    }

    // Getters
    public String getCuit() {
        return this.cuit;
    }

    // Setters
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    // Ejemplo método @Override
    @Override
    public boolean puedeTrabajar() {
        return true;
    }

    // Atributos estáticos
    static int edadMinima = 18;
    static int edadMaxima = 100;

    // Método estático
    static boolean cuitEsValido(String unCuit) {
        // Ejemplo
        return true;
    }
}
