public class CalculadorDeDivision {

    // Enfoque recursivo
    public static int divisionRecursiva(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }

        if (dividend < divisor) {
            return 0;
        } else {
            return 1 + divisionRecursiva(dividend - divisor, divisor);
        }
    }

    // Enfoque iterativo con restas sucesivas
    public static int divisionIterativa(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }

        int cociente = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            cociente++;
        }

        return cociente;
    }
}
