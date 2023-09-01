import java.util.ArrayList;
import java.util.Scanner;

// Paso 1: Clase abstracta Empleado
abstract class Empleado {
    public String getSueldoBase;
    private String nombre;
    private int id;
    private double sueldoBase;

    public Empleado(String nombre, int id, double sueldoBase) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = sueldoBase;
    }

    // Paso 1: Método abstracto calcularSueldo()
    public abstract double calcularSueldo();

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }
}