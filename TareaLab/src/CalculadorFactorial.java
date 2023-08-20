// Clase base para el cálculo del factorial
class CalculadorFactorial {
    public int calculate(int n) {
        return 0; // Este método será sobrecargado en las sub clases
    }
}

// Clase que implementa el cálculo del factorial usando recursión
class CalculadorFactorialRecursivo extends CalculadorFactorial {
    @Override
    public int calculate(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculate(n - 1);
        }
    }
}
// Clase que implementa el cálculo del factorial usando iteración
class CalculadorFactorialIterativo extends CalculadorFactorial {
    @Override
    public int calculate(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
