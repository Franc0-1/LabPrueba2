import java.util.ArrayList;

class GestorEmpleados {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void modificarEmpleado(int indice, Empleado empleado) {
        if (indice >= 0 && indice < empleados.size()) {
            empleados.set(indice, empleado);
        } else {
            System.out.println("Índice de empleado no válido.");
        }
    }

    public void eliminarEmpleado(int indice) {
        if (indice >= 0 && indice < empleados.size()) {
            empleados.remove(indice);
        } else {
            System.out.println("Índice de empleado no válido.");
        }
    }

    public void listarEmpleados() {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            System.out.println("Empleado #" + i);
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("ID: " + empleado.getId());
            System.out.println("Sueldo Base: " + empleado.getSueldoBase());
            System.out.println("Sueldo Calculado: " + empleado.calcularSueldo());

            if (empleado instanceof Impuesto) {
                Impuesto empleadoConImpuesto = (Impuesto) empleado;
                System.out.println("Impuesto a Pagar: " + empleadoConImpuesto.calcularImpuesto());
            }

            System.out.println("------------------");
        }
    }

    public int size() {
        return 0;
    }

    public Empleado getEmpleado(int i) {
        return null;
    }
}
