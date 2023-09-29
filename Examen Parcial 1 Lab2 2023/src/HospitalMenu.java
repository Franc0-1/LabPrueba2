import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class HospitalMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Método para recuperar el nombre del hospital desde un archivo de texto llamado nombreHospital.txt
        String nombreHospital = "";
        try (Scanner entrada = new Scanner(new File("nombreHospital.txt"))) {
            nombreHospital = entrada.nextLine();
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el nombre del Hospital desde el archivo: " + e.getMessage());
        }
        Hospital hospital = new Hospital(nombreHospital);
        int opcion;
        do {
            System.out.println("Hospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399");
            System.out.println("Menú:");
            System.out.println("1. Listar Doctores.");
            System.out.println("2. Registrar un nuevo paciente.");
            System.out.println("3. Actualizar información personal de un paciente.");
            System.out.println("4. Nuevo historial médico para un paciente.");
            System.out.println("5. Consultar el historial médico de un paciente.");
            System.out.println("6. Guardar Historial de pacientes en archivo.");
            System.out.println("7. Cargar Historial de pacientes desde archivo.");
            System.out.println("8. Salir.");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    hospital.listarDoctores();
                    break;
                case 2:
                    // Lógica para registrar un nuevo paciente
                    System.out.println("Ingrese el nombre del paciente (Sin apellido): ");
                    String nombrePaciente = scanner.next();
                    System.out.println("Ingrese el DNI del paciente: ");
                    String dniPaciente = scanner.next();
                    System.out.println("Ingrese la fecha de nacimiento del paciente (dd/MM/yyyy): ");
                    String fechaNacimientoPaciente = scanner.next();
                    System.out.println("Ingrese el número de teléfono del paciente: ");
                    String numeroTelefonoPaciente = scanner.next();
                    System.out.println("Ingrese el tipo de sangre del paciente: ");
                    String tipoSangrePaciente = scanner.next();
                    Paciente nuevoPaciente = new Paciente(nombrePaciente, dniPaciente, fechaNacimientoPaciente, numeroTelefonoPaciente, tipoSangrePaciente);
                    hospital.registrarPaciente(nuevoPaciente);
                    System.out.println("Paciente registrado exitosamente.");
                    break;
                case 3:
                    // Lógica para actualizar información personal de un paciente
                    System.out.println("Ingrese el DNI del paciente que desea actualizar: ");
                    dniPaciente = scanner.next();
                    Paciente pacienteActualizar = hospital.buscarPacientePorDNI(dniPaciente);
                    if (pacienteActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del paciente: ");
                        String nuevoNombre = scanner.next();
                        System.out.println("Ingrese la nueva fecha de nacimiento del paciente (dd/MM/yyyy): ");
                        String nuevaFechaNacimiento = scanner.next();

                        pacienteActualizar.setNombre(nuevoNombre);
                        pacienteActualizar.setFechaNacimiento(nuevaFechaNacimiento);

                        System.out.println("Información actualizada exitosamente.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 4:
                    // Lógica para agregar un nuevo evento al historial médico de un paciente
                    System.out.println("Ingrese el DNI del paciente al que desea agregar un evento: ");
                    dniPaciente = scanner.next();
                    pacienteActualizar = hospital.buscarPacientePorDNI(dniPaciente);
                    if (pacienteActualizar != null) {
                        System.out.println("Ingrese la fecha del evento (dd/MM/yyyy): ");
                        String fechaEvento = scanner.next();
                        scanner.nextLine(); // Consumir el carácter de nueva línea pendiente

                        System.out.println("Ingrese las observaciones del evento: ");
                        String observacionesEvento = scanner.nextLine();

                        pacienteActualizar.agregarEventoHistorial(fechaEvento + " - " + observacionesEvento);
                        System.out.println("Evento agregado al historial médico exitosamente.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 5:
                    // Lógica para consultar el historial médico de un paciente
                    System.out.println("Ingrese el DNI del paciente cuyo historial desea consultar: ");
                    dniPaciente = scanner.next();
                    pacienteActualizar = hospital.buscarPacientePorDNI(dniPaciente);
                    if (pacienteActualizar != null) {
                        pacienteActualizar.verHistorialDeEventos();
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 6:
                    // Lógica para guardar historiales de pacientes en un archivo
                    hospital.guardarPacientesEnArchivo("pacientes.dat");
                    break;
                case 7:
                    // Lógica para cargar historiales de pacientes desde un archivo
                    hospital = Hospital.cargarPacientesDesdeArchivo("pacientes.dat");
                    if (hospital != null) {
                        System.out.println("Historiales cargados desde archivo exitosamente.");
                    } else {
                        System.out.println("Error al cargar los historiales desde el archivo.");
                    }
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (opcion != 8);
        scanner.close();
    }
}

class Hospital implements Serializable{
    private String nombre;
    private List<Doctor> doctores;
    private List<Paciente> pacientes;

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        doctores.add(new Doctor("Dr. Juan Pérez", "12345678", "15/03/1970", "Cardiología"));
        doctores.add(new Doctor("Dra. María Rodríguez", "23456789", "22/06/1982", "Pediatría"));
        doctores.add(new Doctor("Dr. Marcelo Esquivel", "444789633", "15/10/2002", "Neurólogo"));
    }

    public String getNombre() {
        return nombre;
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void listarDoctores() {
        for (Doctor doctor : doctores) {
            System.out.println(doctor.getNombre() + " - " + doctor.getDni() + " - " + doctor.getFechaNacimiento() + " - " + doctor.getEspecialidad());
        }
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente buscarPacientePorDNI(String dni) {
        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dni)) {
                return paciente;
            }
        }
        return null;
    }

    public void guardarPacientesEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(this);
            System.out.println("Eventos guardados en archivo exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los eventos en el archivo: " + e.getMessage());
        }
    }

    public static Hospital cargarPacientesDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Hospital) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los Eventos desde el archivo: " + e.getMessage());
            return null;
        }
    }
}

class Doctor extends Persona {
    private String especialidad;

    public Doctor(String nombre, String dni, String fechaNacimiento, String especialidad) {
        super(nombre, dni, fechaNacimiento);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}

class Paciente extends Persona implements Informacion {
    private String numeroTelefono;
    private String tipoSangre;
    private List<String> historialMedico;

    public Paciente(String nombre, String dni, String fechaNacimiento, String numeroTelefono, String tipoSangre) {
        super(nombre, dni, fechaNacimiento);
        this.numeroTelefono = numeroTelefono;
        this.tipoSangre = tipoSangre;
        this.historialMedico = new ArrayList<>();
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public List<String> getHistorialMedico() {
        return historialMedico;
    }

    public void agregarEventoHistorial(String evento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = sdf.format(new Date());
        String eventoCompleto = fechaActual + " - " + evento;
        historialMedico.add(eventoCompleto);
    }

                @Override
                public void verHistorialDeEventos() {
                    if (historialMedico.isEmpty()) {
                        System.out.println("El historial médico está vacío.");
                    } else {
                        System.out.println("HISTORIAL MÉDICO:");
                        for (String evento : historialMedico) {
                            System.out.println(evento);
                        }
                    }
                }

    public void setNombre(String nombrePaciente) {
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
}

            class Persona implements Serializable {
                private String nombre;
                private String dni;
                protected String fechaNacimiento;

                public Persona(String nombre, String dni, String fechaNacimiento) {
                    this.nombre = nombre;
                    this.dni = dni;
                    this.fechaNacimiento = fechaNacimiento;
                }

                public String getNombre() {
                    return nombre;
                }

                public String getDni() {
                    return dni;
                }

                public String getFechaNacimiento() {
                    return fechaNacimiento;
                }
            }

            interface Informacion {
                void verHistorialDeEventos();
            }

            class Menu {
                private Hospital hospital;

                public Menu(Hospital hospital) {
                    this.hospital = hospital;
                }

                public void showMenu() {
                    // Add your menu options and logic here
                    System.out.println("Hospital Menu");
                }

                public void guardarPacientesEnArchivo(String nombreArchivo) {
                    try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
                        salida.writeObject(this);
                        System.out.println("Pacientes guardados en archivo exitosamente.");
                    } catch (IOException e) {
                        System.err.println("Error al guardar los Pacientes en el archivo: " + e.getMessage());
                    }
                }

                public static Hospital cargarPacientesDesdeArchivo(String nombreArchivo) {
                    try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
                        return (Hospital) entrada.readObject();
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Error al cargar los Pacientes desde el archivo: " + e.getMessage());
                        return null;
                    }
                }
            }
class contactoHospital {
    public static void main(String[] args) {
        String datosContacto = cargarDatosDeContacto("datos.txt");

        System.out.println("Hospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399");
        System.out.println("Datos de contacto:");
        System.out.println(datosContacto);

        // Resto del menú y lógica del programa
    }

    public static String cargarDatosDeContacto(String nombreArchivo) {
        try {
            return new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        } catch (IOException e) {
            System.err.println("Error al cargar los datos de contacto desde el archivo: " + e.getMessage());
            return "";
        }
    }
}
