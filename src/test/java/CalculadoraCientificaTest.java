import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraCientificaTest {

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
}