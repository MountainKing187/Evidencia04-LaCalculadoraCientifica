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
}