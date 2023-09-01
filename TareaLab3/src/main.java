import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Modificar Empleado");
            System.out.println("3. Eliminar Empleado");
            System.out.println("4. Listar Empleados");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Sueldo Base: ");
                    double sueldoBase = scanner.nextDouble();
                    System.out.print("Tipo de Empleado (1: Por Horas, 2: Asalariado, 3: Comisión): ");
                    int tipoEmpleado = scanner.nextInt();

                    Empleado empleado = null;

                    switch (tipoEmpleado) {
                        case 1:
                            System.out.print("Horas Trabajadas: ");
                            int horasTrabajadas = scanner.nextInt();
                            empleado = new EmpleadoPorHoras(nombre, id, sueldoBase, horasTrabajadas);
                            break;
                        case 2:
                            empleado = new EmpleadoAsalariado(nombre, id, sueldoBase);
                            break;
                        case 3:
                            System.out.print("Ventas Realizadas: ");
                            double ventasRealizadas = scanner.nextDouble();
                            empleado = new EmpleadoComision(nombre, id, sueldoBase, ventasRealizadas);
                            break;
                        default:
                            System.out.println("Tipo de Empleado no válido.");
                            break;
                    }

                    if (empleado != null) {
                        gestor.agregarEmpleado(empleado);
                        System.out.println("Empleado agregado con éxito.");
                    }
                    break;
                case 2:
                    System.out.print("Índice del Empleado a Modificar: ");
                    int indiceModificar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    if (indiceModificar >= 0 && indiceModificar < gestor.size()) {
                        Empleado empleadoExistente = gestor.getEmpleado(indiceModificar);
                        System.out.println("Empleado actual:");
                        System.out.println("Nombre: " + empleadoExistente.getNombre());
                        System.out.println("ID: " + empleadoExistente.getId());
                        System.out.println("Sueldo Base: " + empleadoExistente.getSueldoBase);
                        System.out.print("Nuevo Nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Nuevo ID: ");
                        int nuevoId = scanner.nextInt();
                        System.out.print("Nuevo Sueldo Base: ");
                        double nuevoSueldoBase = scanner.nextDouble();
                        System.out.print("Tipo de Empleado (1: Por Horas, 2: Asalariado, 3: Comisión): ");
                        int nuevoTipoEmpleado = scanner.nextInt();

                        Empleado empleadoModificado = null;

                        switch (nuevoTipoEmpleado) {
                            case 1:
                                System.out.print("Horas Trabajadas: ");
                                int horasTrabajadas = scanner.nextInt();
                                empleadoModificado = new EmpleadoPorHoras(nuevoNombre, nuevoId, nuevoSueldoBase, horasTrabajadas);
                                break;
                            case 2:
                                empleadoModificado = new EmpleadoAsalariado(nuevoNombre, nuevoId, nuevoSueldoBase);
                                break;
                            case 3:
                                System.out.print("Ventas Realizadas: ");
                                double ventasRealizadas = scanner.nextDouble();
                                empleadoModificado = new EmpleadoComision(nuevoNombre, nuevoId, nuevoSueldoBase, ventasRealizadas);
                                break;
                            default:
                                System.out.println("Tipo de Empleado no válido.");
                                break;
                        }

                        if (empleadoModificado != null) {
                            gestor.modificarEmpleado(indiceModificar, empleadoModificado);
                            System.out.println("Empleado modificado con éxito.");
                        }
                    } else {
                        System.out.println("Índice de empleado no válido.");
                    }
                    break;
                case 3:
                    System.out.print("Índice del Empleado a Eliminar: ");
                    int indiceEliminar = scanner.nextInt();

                    if (indiceEliminar >= 0 && indiceEliminar < gestor.size()) {
                        gestor.eliminarEmpleado(indiceEliminar);
                        System.out.println("Empleado eliminado con éxito.");
                    } else {
                        System.out.println("Índice de empleado no válido.");
                    }
                    break;
                case 4:
                    gestor.listarEmpleados();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}