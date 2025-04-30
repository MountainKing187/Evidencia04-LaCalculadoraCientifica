import java.awt.geom.Area;
import java.util.Scanner;

public class CalculadoraCientifica {

    private static final Scanner sc = new Scanner(System.in);

    //  Operaciones Iniciales
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        mostrarMenu();
        ejecutarOpcion(escribirInt());
    }

    public static int stringToint(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Ingrese un numero valido");
            menu();
            return 0;
        }
    }

    public static double stringToDouble(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Ingrese un numero valido");
            menu();
            return Double.NaN;
        }
    }

    public static double escribirDouble() {
        return stringToDouble(sc.next());
    }

    public static int escribirInt() {
        return stringToint(sc.next());
    }

    public static void mostrarMenu() {
        System.out.println("Menu Principal");
        System.out.println("1- Operacion Aritmetica");
        System.out.println("2- Ecuacion Cuadratica");
        System.out.println("3- Figura Geometrica");
        System.out.println("4- Sist. Operaciones Lineales");
        System.out.println("5- Ecuacion de la Recta");
        System.out.println("6- Salir");
        System.out.println("Selecciona una opcion:");
    }

    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> operacionAritmetica();
            case 2 -> ecuacionCuadratica();
            case 3 -> figuraGeometrica();
            case 4 -> sistOperacionesLineales();
            case 5 -> opcionEcuacionRecta();
            case 6 -> System.exit(1);
            default -> System.out.println("Opcion invalida");
        }
    }
//  Aritmetica______________________________________________________
    public static void operacionAritmetica(){
        menuAritmeticas();
        int opcion = escribirInt();
        if (opcion != 0){
            opcionMenuAritmetica(opcion);
        }

    }

    public static void menuAritmeticas(){
        System.out.println("Operaciones Aritmeticas");
        System.out.println("1- Suma");
        System.out.println("2- Resta");
        System.out.println("3- Multiplicacion");
        System.out.println("4- Divison");
        System.out.println("5- Mayor");
        System.out.println("6- Menor");
        System.out.println("7- Potencia");
        System.out.println("8- Porcentaje");
        System.out.println("9- Volver al Menu Principal");
        System.out.println("Selecciona una opcion:");
    }

    public static void opcionMenuAritmetica(int opcion){
        if (opcion == 9) {menu();}
        System.out.println("Ingrese el primer numero");
        double n1 = escribirDouble();
        System.out.println("Ingrese el segundo numero");
        double n2 = escribirDouble();
        double n3 = 0;
        switch (opcion) {
            case 1: n3 = sumaAritmetica(n1,n2); break;
            case 2: n3 = restaAritmetica(n1,n2);break;
            case 3: n3 = multiplicacionAritmetica(n1,n2);break;
            case 4: n3 = divisionAritmetica(n1,n2);break;
            case 5: n3 = mayorAritmetica(n1,n2);break;
            case 6: n3 = menorAritmetica(n1,n2);break;
            case 7: n3 = potenciaAritmetica(n1,n2);break;
            case 8: n3 = porcentajeAritmetica(n1,n2);break;
            default: System.out.println("Opcion invalida");
        }
        printaritmetica(opcion,n3);
    }

    public static void printaritmetica(int opcion, double n3){
        switch (opcion) {
            case 1:
                System.out.println("La suma da total " + n3);
                break;
            case 2:
                System.out.println("La resta da total " + n3);
                break;
            case 3:
                System.out.println("La multiplicacion da total " + n3);
                break;
            case 4:
                if (Double.isNaN(n3)) {System.out.println("No se puede dividir 0");}
                else {System.out.println("La division da total " + n3);}
                break;
            case 5:
                System.out.println("El mayor valor es " + n3);
                break;
            case 6:
                System.out.println("El menor valor es " + n3);
                break;
            case 7:
                System.out.println("La potencia da " + n3);
                break;
            case 8:
                System.out.println("El porcentaje da " + n3);
                break;
        }
        operacionAritmetica();
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
        return Math.max(n1, n2);
    }

    public static double menorAritmetica(double n1, double n2) {
        return Math.min(n1, n2);
    }

    public static double potenciaAritmetica(double n1, double n2) {
        return Math.pow(n1, n2);
    }

    public static double porcentajeAritmetica(double n1, double n2) {

        return n1 * n2 / 100;
    }

//  Ecuacion Cuadratica
    public static void ecuacionCuadratica(){
        System.out.println("Ingrese Valores de la ecuación cuadratica");
        double a = escribirDouble();
        double b = escribirDouble();
        double c = escribirDouble();
        System.out.println("La ecuacion y sus soluciones son:");
        System.out.println(a + "x^2 + " + b + " + "+ c +" = 0");
        double[] x = resuelvaCuadratica(a,b,c);
        System.out.println("X1: " + x[0] + " y X2: " + x[1]);
        menu();
    }

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
            System.out.println("No tiene solucion");
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

//  Sistema Ecuaciones Lineales

    public static void sistOperacionesLineales(){
        System.out.println("Ingrese valores de la primera ecuacion");
        double[]ec1 = ingresar3double();
        System.out.println("Ecuacion 1:" +ec1[0]+"x^2+"+ec1[1]+"+"+ec1[2]+"=0");
        System.out.println("Ingrese valores de la Segunda ecuacion");
        double[]ec2 = ingresar3double();
        System.out.println("Ecuacion 1:" +ec1[0]+"*X+"+ec1[1]+"*Y+"+ec1[2]+"=0");
        System.out.println("Ecuacion 2:" +ec2[0]+"*X+"+ec2[1]+"*Y+"+ec2[2]+"=0");
        double[] sol = resolverSistema(ec1[0],ec1[1],ec1[2],ec2[0],ec2[1],ec2[2]);

        if(sol == null){System.out.println("Sistema no tiene solucion unica");}
        else {System.out.println("Las soluciones al systema son: X="+sol[0]+", Y="+sol[1]);}

        menu();
    }

    public static double[] ingresar3double(){
        System.out.println("Valor 1");
        double A = escribirDouble();
        System.out.println("Valor 2");
        double B = escribirDouble();
        System.out.println("Valor 3");
        double C = escribirDouble();
        return new double[]{A,B,C};
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

    public static void opcionEcuacionRecta(){
        double[] puntos = obtenerPuntos();

        double[] bym = calcularEcuacionRecta(puntos[0],puntos[1],puntos[2],puntos[3]);

        System.out.println("Su ecuacion de la recta es:");
        System.out.println("y = "+bym[0]+" * x + "+bym[1]);
    }

    public static double[] obtenerPuntos() {
        System.out.println("Ingrese el X del primer punto");
        double n1 = escribirDouble();
        System.out.println("Ingrese el Y del primer punto");
        double n2 = escribirDouble();
        System.out.println("Ingrese el X del segundo punto");
        double n3 = escribirDouble();
        System.out.println("Ingrese el Y del segundo punto");
        double n4 = escribirDouble();

        return new double[]{n1, n2, n3, n4};
    }

    public static double[] calcularEcuacionRecta(double x1, double y1, double x2, double y2) {
        // Calcular pendiente (m)
        double m = (y2 - y1) / (x2 - x1);

        // Calcular intercepto (b) usando y = mx + b => b = y - mx
        double b = y1 - m * x1;

        return new double[]{m, b};
    }

    public static void figuraGeometrica(){
        mostrarFiguras();
        int opcion = escribirInt();

        switch (opcion){
            case 1 -> opcionCuadrado();
            case 2 -> opcionRectangulo();
            case 3 -> opcionCirculo();
            case 4 -> opcionEsfera();
            case 5 -> opcionCubo();
            case 6 -> opcionCono();
            case 7 -> menu();
        }
    }

    public static void mostrarFiguras(){
        System.out.println("Figuras geometricas");
        System.out.println("1- Calcular Perimetro o Area de Cuadrado");
        System.out.println("2- Calcular Perimetro o Area de Rectangulo");
        System.out.println("3- Calcular Perimetro o Area de Circulo");
        System.out.println("4- Calcular Volumen de Esfera");
        System.out.println("5- Calcular Volumen de Cubo");
        System.out.println("6- Calcular Volumen de Cono");
        System.out.println("7- Volver al Menu Principal");
        System.out.println("Selecciona una opcion:");
    }

    public static void opcionCuadrado(){
        System.out.println("Ingrese el largo del lado de su cuadrado");
        double n1 = escribirDouble();

        System.out.println("Operaciones de un Cuadrado");
        System.out.println("1- Calcular Perimetro");
        System.out.println("2- Calcular Area");
        System.out.println("Ingrese su opcion");
        int opcion = escribirInt();
        double resultado = 0;

        switch (opcion) {
            case 1 -> resultado = perimetroCuadrado(n1);
            case 2 -> resultado = areaCuadrado(n1);
            default -> System.out.println("Opcion invalida");
        }
        System.out.println(resultado);
    }

    public static void opcionRectangulo(){
        System.out.println("Ingrese el largo de su rectangulo");
        double n1 = escribirDouble();

        System.out.println("Ingrese el ancho de su rectangulo");
        double n2 = escribirDouble();

        System.out.println("Operaciones de un Rectangulo");
        System.out.println("1- Calcular Perimetro");
        System.out.println("2- Calcular Area");
        System.out.println("Ingrese su opcion");
        int opcion = escribirInt();
        double resultado = 0;

        switch (opcion) {
            case 1 -> resultado = perimetroRectangulo(n1,n2);
            case 2 -> resultado = areaRectangulo(n1,n2);
            default -> System.out.println("Opcion invalida");
        }
        System.out.println(resultado);
    }
    public static void opcionCirculo(){
        System.out.println("Ingrese el largo del radio de su circulo");
        double n1 = escribirDouble();

        System.out.println("Operaciones de un Circulo");
        System.out.println("1- Calcular Perimetro");
        System.out.println("2- Calcular Area");
        System.out.println("Ingrese su opcion");
        int opcion = escribirInt();
        double resultado = 0;

        switch (opcion) {
            case 1 -> resultado = perimetroCirculo(n1);
            case 2 -> resultado = areaCirculo(n1);
            default -> System.out.println("Opcion invalida");
        }
        System.out.println(resultado);
    }

    public static void opcionCubo(){
        System.out.println("Ingrese el largo de un lado de su cubo");
        double n1 = escribirDouble();
        double resultado = 0;

        resultado = volumenCubo(n1);
        System.out.println(resultado);
    }

    public static void opcionEsfera(){
        System.out.println("Ingrese el largo del radio de su esfera");
        double n1 = escribirDouble();
        double resultado = 0;

        resultado = volumenEsfera(n1);
        System.out.println(resultado);
    }

    public static void opcionCono(){
        System.out.println("Ingrese el radio de la base de su cono");
        double n1 = escribirDouble();

        System.out.println("Ingrese el largo de su cono");
        double n2 = escribirDouble();

        double resultado = 0;
        resultado = volumenCono(n1,n2);
        System.out.println(resultado);
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
