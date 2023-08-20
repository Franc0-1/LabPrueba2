import java.util.Scanner;

class SaludoNombre {
    public static String saludar(String nombre) {
        String mensaje = "Hola! " + nombre + " Bienvenido!";
        return mensaje;
    }


    public static void main(String[] args) {
        System.out.println("Hola Buenos dias Con quien tengo el gusto de hablar?");

Scanner name = new Scanner(System.in);
String nombre = name.nextLine();
String saludo = saludar(nombre);
        System.out.println(saludo);
        }
    }




