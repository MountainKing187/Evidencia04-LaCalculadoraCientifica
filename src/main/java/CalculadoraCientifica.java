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
}
