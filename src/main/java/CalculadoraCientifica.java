import java.util.Scanner;

public class CalculadoraCientifica {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        int option = sc.nextInt();
        do {
            mostrarMenu();
        } while (option != 6);
    }

    private static void mostrarMenu() {
        System.out.println("Menu Principal");
        System.out.println("1- Operacion Aritmetica");
        System.out.println("2- Ecuacion Cuadratica");
        System.out.println("3- Figura Geometrica");
        System.out.println("4- Sist. Operaciones Lineales");
        System.out.println("5- Ecuacion de la Recta");
        System.out.println("6- Salir");
        System.out.println("Selecciona una opcion:");
    }


    //  Resuelve las 4 operaciones en 1
    public static double sumaAritmetica(double n1, double n2) {return n1 + n2;}
    public static double restaAritmetica(double n1, double n2) {return n1 - n2;}
    public static double multiplicacionAritmetica(double n1, double n2) {return n1 * n2;}
    public static double divisionAritmetica(double n1, double n2) {
        if (n2 == 0) {
            return Double.NaN;
        }else {
            return n1/n2;
        }
    }

    public static double mayorAritmetica(double n1, double n2) {
        if (n1 > n2) {
            return n1;
        } else {
            return n2;
        }
    }

    public static double menorAritmetica(double n1, double n2) {
        if (n1 < n2) {
            return n1;
        } else {
            return n2;
        }
    }

    public static double potenciaAritmetica(double n1, double n2) {
        return Math.pow(n1, n2);
    }

    public static double porcentajeAritmetica(double n1, double n2) {

        return n1 * n2 / 100;
    }

    //  resuelve la ecuacion en 2
    public static double[] resuelvaCuadratica(double a, double b, double c) {
        double determinante = Math.pow(b, 2) - 4 * a * c;
        double x1, x2;

        if (determinante == 0) {
            x1 = x2 = -b / (2 * a);
        } else if (determinante > 0) {
            x1 = formulaCuadratica(determinante, a, b, true);
            x2 = formulaCuadratica(determinante, a, b, false);
        } else {
            x1 = Double.NaN;
            x2 = Double.NaN;
        }

        return new double[]{x1, x2};
    }

    private static double formulaCuadratica(double determinante, double a, double b, boolean positivo) {
        if (positivo) {
            return (-b + Math.sqrt(determinante)) / (2 * a);
        } else {
            return (-b - Math.sqrt(determinante)) / (2 * a);
        }
    }


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
