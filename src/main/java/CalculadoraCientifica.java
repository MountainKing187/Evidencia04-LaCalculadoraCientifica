public class CalculadoraCientifica {

    public static double[] resolverSistema(double A, double B, double C,
                                           double D, double E, double F) {
        // Calculamos el determinante del sistema
        double determinante = A * E - B * D;

        // Si el determinante es cero, el sistema no tiene solución única
        if (determinante == 0) {
            return null; // No hay solución única (sistema incompatible o indeterminado)
        }

        // Calculamos x e y usando la regla de Cramer
        double x = (C * E - B * F) / determinante;
        double y = (A * F - C * D) / determinante;

        return new double[]{x, y};
    }

    public static double[] calcularEcuacionRecta(double x1, double y1, double x2, double y2) {
        // Calcular pendiente (m)
        double m = (y2 - y1) / (x2 - x1);

        // Calcular intercepto (b) usando y = mx + b => b = y - mx
        double b = y1 - m * x1;

        return new double[]{m, b};
    }

    public static double perimetroCuadrado(double lado) {
        return 4 * lado;
    }

    public static double areaCuadrado(double lado) {
        return lado * lado;
    }

    public static double perimetroRectangulo(double base, double altura) {
        return 2 * (base + altura);
    }

    public static double areaRectangulo(double base, double altura) {
        return base * altura;
    }

    public static double perimetroCirculo(double radio) {
        return 2 * Math.PI * radio;
    }

    public static double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    public static double volumenEsfera(double radio) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    public static double volumenCubo(double arista) {
        return Math.pow(arista, 3);
    }

    public static double volumenCono(double radio, double altura) {
        return (1.0 / 3.0) * Math.PI * radio * radio * altura;
    }
}
