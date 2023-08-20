public class CalculadorDeSumaRecursiva {

    // Función recursiva para calcular la sumatoria
    public static int calcularSumatoriaRecursiva(int n) {
        // Caso base: cuando n es 1, la sumatoria es 1
        if (n == 1) {
            return 1;
        } else {
            // Llamada recursiva para sumar n y el resultado de sumar 1 hasta n-1
            return n + calcularSumatoriaRecursiva(n - 1);
        }
    }
}