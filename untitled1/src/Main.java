import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Crear una cuenta con titular y cantidad
        Cuenta cuenta1 = new Cuenta("Juan Pérez", 1000.0);

        // Acceder a los atributos de la cuenta
        String titular = cuenta1.getTitular();
        double cantidad = cuenta1.getCantidad();
        System.out.println("Titular: " + titular); // Imprime "Titular: Juan Pérez"
        System.out.println("Cantidad: " + cantidad); // Imprime "Cantidad: 1000.0"

        // Modificar los atributos de la cuenta
        cuenta1.setTitular("María Gómez");
        cuenta1.setCantidad(1500.0);

        // Acceder nuevamente a los atributos de la cuenta
        titular = cuenta1.getTitular();
        cantidad = cuenta1.getCantidad();
        System.out.println("Titular: " + titular); // Imprime "Titular: María Gómez"
        System.out.println("Cantidad: " + cantidad); // Imprime "Cantidad: 1500.0"

        // Crear una cuenta con solo titular
        Cuenta cuenta2 = new Cuenta("Carlos López");

        // Acceder a los atributos de la cuenta
        titular = cuenta2.getTitular();
        cantidad = cuenta2.getCantidad();
        System.out.println("Titular: " + titular); // Imprime "Titular: Carlos López"
        System.out.println("Cantidad: " + cantidad); // Imprime "Cantidad: 0.0"

System.out.println("Registre su cuenta");
        Cuenta cuenta3 = new Cuenta(scanner.nextLine(), scanner.nextInt());

        titular = cuenta3.getTitular();
        cantidad = cuenta3.getCantidad();
        System.out.println("Titular: " + titular); // Imprime "Titular: María Gómez"
        System.out.println("Cantidad: " + cantidad); // Imprime "Cantidad: 1500.0"




    }
}








