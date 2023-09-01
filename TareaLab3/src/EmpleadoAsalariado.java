class EmpleadoAsalariado extends Empleado {
    public EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        super(nombre, id, sueldoBase);
    }

    // Implementación de calcularSueldo() para EmpleadoAsalariado
    @Override
    public double calcularSueldo() {
        return getSueldoBase();
    }
}

