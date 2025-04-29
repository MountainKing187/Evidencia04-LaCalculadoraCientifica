import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraCientificaTest {

    //Tests para resolver los sistemas 2x2
    @Test
    void testSistemaConSolucionUnica() {
        // Sistema:
        // 2x + 3y = 6
        // x - y = 1
        // Solución esperada: x = 1.8, y = 0.8

        double[] solucion = CalculadoraCientifica.resolverSistema(2, 3, 6, 1, -1, 1);

        assertNotNull(solucion);
        assertEquals(2, solucion.length);

        assertEquals(1.8, solucion[0]);
        assertEquals(0.8, solucion[1]);
    }

    @Test
    void testSistemaSinSolucionUnica() {
        // Sistema:
        // 2x + 4y = 6
        // 1x + 2y = 3
        // Las ecuaciones son equivalentes (la segunda es la primera dividida por 2)
        // No hay solución única (infinitas soluciones)
        double[] solucion = CalculadoraCientifica.resolverSistema(2, 4, 6, 1, 2, 3);

        assertNull(solucion);
    }

    //Tests para obtener b y m
    @Test
    void testRectaConPendientePositiva() {
        // Puntos (1, 2) y (3, 4)
        // Pendiente esperada (m): (4-2)/(3-1) = 2/2 = 1
        // Intercepto esperado (b): 2 - (1*1) = 1
        double[] resultado = CalculadoraCientifica.calcularEcuacionRecta(1, 2, 3, 4);

        assertEquals(2, resultado.length);

        // Verificar pendiente (m)
        assertEquals(1.0, resultado[0]);

        // Verificar intercepto (b)
        assertEquals(1.0, resultado[1]);
    }

    @Test
    void testRectaConPendienteNegativa() {
        // Puntos (2, 5) y (4, 1)
        // Pendiente esperada (m): (1-5)/(4-2) = -4/2 = -2
        // Intercepto esperado (b): 5 - (-2*2) = 5 + 4 = 9
        double[] resultado = CalculadoraCientifica.calcularEcuacionRecta(2, 5, 4, 1);

        assertEquals(2, resultado.length);

        // Verificar pendiente (m)
        assertEquals(-2.0, resultado[0]);

        // Verificar intercepto (b)
        assertEquals(9.0, resultado[1]);
    }

    //Tests para calcular figuras geometricas

    //CUADRADO
    @Test
    void testPerimetroCuadrado() {
        assertEquals(20.0, CalculadoraCientifica.perimetroCuadrado(5.0));
        assertEquals(7.2, CalculadoraCientifica.perimetroCuadrado(1.8));
    }

    @Test
    void testAreaCuadrado() {
        assertEquals(25.0, CalculadoraCientifica.areaCuadrado(5.0));
        assertEquals(3.24, CalculadoraCientifica.areaCuadrado(1.8));
    }

    //RECTÁNGULO
    @Test
    void testPerimetroRectangulo() {
        assertEquals(14.0, CalculadoraCientifica.perimetroRectangulo(3.0, 4.0));
        assertEquals(10.4, CalculadoraCientifica.perimetroRectangulo(2.5, 2.7));
    }

    @Test
    void testAreaRectangulo() {
        assertEquals(12.0, CalculadoraCientifica.areaRectangulo(3.0, 4.0));
        assertEquals(6.75, CalculadoraCientifica.areaRectangulo(2.5, 2.7));
    }

    //CÍRCULO
    @Test
    void testPerimetroCirculo() {
        assertEquals(2 * Math.PI * 3.0, CalculadoraCientifica.perimetroCirculo(3.0));
        assertEquals(2 * Math.PI * 1.5, CalculadoraCientifica.perimetroCirculo(1.5));
    }

    @Test
    void testAreaCirculo() {
        assertEquals(Math.PI * 9.0, CalculadoraCientifica.areaCirculo(3.0));
        assertEquals(Math.PI * 2.25, CalculadoraCientifica.areaCirculo(1.5));
    }

    //ESFERA
    @Test
    void testVolumenEsfera() {
        assertEquals((4.0/3.0) * Math.PI * 27.0, CalculadoraCientifica.volumenEsfera(3.0));
        assertEquals((4.0/3.0) * Math.PI * 15.625, CalculadoraCientifica.volumenEsfera(2.5));
    }

    //CUBO
    @Test
    void testVolumenCubo() {
        assertEquals(27.0, CalculadoraCientifica.volumenCubo(3.0));
        assertEquals(2.197, CalculadoraCientifica.volumenCubo(1.3));
    }

    //CONO
    @Test
    void testVolumenCono() {
        double radio = 3.0;
        double altura = 4.0;
        double expected = (1.0/3.0) * Math.PI * radio * radio * altura;
        assertEquals(expected, CalculadoraCientifica.volumenCono(radio, altura));
    }
}