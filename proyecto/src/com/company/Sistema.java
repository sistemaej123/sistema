package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Sistema {
    HashSet<Empleado> empleados;
    HashMap<String, Empleado> empleadoSegunCuit;
    // Usar Scanners diferentes para strings e ints
    Scanner scStrings;
    Scanner scInts;

    public Sistema() {
        this.empleados = new HashSet<>();
        this.empleadoSegunCuit = new HashMap<>();
        this.scStrings = new Scanner(System.in);
        this.scInts = new Scanner(System.in);
    }

    public void iniciarSistema() {
        boolean usuarioSalio = false;
        while(!usuarioSalio) usuarioSalio = this.menuPrincipal();
    }

    private boolean menuPrincipal() {
        System.out.println("\nIngrese 0 para agregar empleado, 1 para ver empleado, 2 para eliminar empleado, 3 para salir.");
        // Usar otro Scanner para ints
        int respuesta = this.scInts.nextInt();

        if (respuesta == 0) this.menuAgregarEmpleado();
        else if (respuesta == 1) this.menuVerEmpleado();
        else if (respuesta == 2) this.menuEliminarEmpleado();
        else if (respuesta == 3) return true;

        return false;
    }
    private void menuAgregarEmpleado() {
        System.out.println("Ingrese nombre empleado");
        String nombre = this.scStrings.nextLine();

        boolean edadValidaIngresada = false;
        int edad = -1;
        while (!edadValidaIngresada) {
            System.out.println("Ingrese edad empleado");
            edad = this.scInts.nextInt();
            if (edad >= Empleado.edadMinima && edad <= Empleado.edadMaxima) {
                edadValidaIngresada = true;
            }
        }

        System.out.println("Ingrese CUIT empleado");
        String cuit = this.scStrings.nextLine();

        Empleado emp = new Empleado(nombre, edad, cuit);
        this.empleados.add(emp);
        this.empleadoSegunCuit.put(cuit, emp);
    }
    private void menuVerEmpleado() {
        System.out.println("Ingrese CUIT empleado");
        String cuit = this.scStrings.nextLine();

        Empleado emp = this.empleadoSegunCuit.get(cuit);
        if (emp != null) {
            // El empleado existe
            String nombre = emp.getNombre();
            int edad = emp.getEdad();
            System.out.println(nombre + ", edad: " + edad + ", CUIT: " + cuit);
        } else {
            System.out.println("No hay ningun empleado con ese CUIT!");
        }
    }
    private void menuEliminarEmpleado() {
        System.out.println("Ingrese CUIT empleado");
        String cuit = this.scStrings.nextLine();

        Empleado emp = this.empleadoSegunCuit.get(cuit);
        if (emp != null) {
            // El empleado existe
            this.empleados.remove(emp);
            this.empleadoSegunCuit.remove(cuit);
            System.out.println("Empleado eliminado");
        } else {
            System.out.println("No hay ningun empleado con ese CUIT!");
        }
    }
}
