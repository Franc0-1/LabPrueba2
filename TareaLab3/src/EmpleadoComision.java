class EmpleadoComision extends Empleado implements Impuesto {
    private double ventasRealizadas;

    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas) {
        super(nombre, id, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    // Implementación de calcularSueldo() para EmpleadoComision
    @Override
    public double calcularSueldo() {
        return getSueldoBase() + (0.1 * ventasRealizadas); // 10% de comisión
    }

    // Implementación de calcularImpuesto() para EmpleadoComision
    @Override
    public double calcularImpuesto() {
        return 0.15 * calcularSueldo(); // Impuesto del 15%
    }
}

// Paso 3: Interfaz Impuesto
interface Impuesto {
    double calcularImpuesto();
}
