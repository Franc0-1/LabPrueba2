class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        super(nombre, id, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    // Implementación de calcularSueldo() para EmpleadoPorHoras
    @Override
    public double calcularSueldo() {
        return getSueldoBase() * horasTrabajadas;
    }
}