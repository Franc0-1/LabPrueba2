// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
public class Main {
    public static void main(String[] args) {
        //Inicio del programa sobre factoriales
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingrese un número entero para calcular su factorial: ");
        int num = scanner.nextInt();
// Crear un objeto de la clase CalculadorFactorialRecursivo
        CalculadorFactorialRecursivo CalculadorRecursivo = new CalculadorFactorialRecursivo();
        int ResultadoRecursivo = CalculadorRecursivo.calculate(num);
        System.out.println("Factorial usando recursión: " + ResultadoRecursivo );
// Crear un objeto de la clase CalculadorFactorialIterativo
        CalculadorFactorialIterativo Calculadoriterativo = new CalculadorFactorialIterativo();
        int ResultadoIterativo = Calculadoriterativo.calculate(num);
        System.out.println("Factorial usando iteración: " + ResultadoIterativo);


// Inicio del programa de division
        System.out.print("Ingresa el dividendo: ");
        int dividend = scanner.nextInt();

        System.out.print("Ingresa el divisor: ");
        int divisor = scanner.nextInt();

        int resultadoRecursivo = CalculadorDeDivision.divisionRecursiva(dividend, divisor);
        int resultadoIterativo = CalculadorDeDivision.divisionIterativa(dividend, divisor);

        System.out.println("Resultado de la división recursiva: " + resultadoRecursivo);
        System.out.println("Resultado de la división iterativa: " + resultadoIterativo);

//Inicio del programa sobre la suma recursiva
        System.out.print("Ingresa un número para calcular la sumatoria: ");
        int numero = scanner.nextInt();

        int sumatoria = CalculadorDeSumaRecursiva.calcularSumatoriaRecursiva(numero);

        System.out.println("La sumatoria de los números enteros desde 1 hasta " + numero + " es: " + sumatoria);


    }
}