package org.example;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class CoshTest {

    @Test
    public void testGetCosh() {
        BigDecimal x = new BigDecimal("0");
        BigDecimal expected = BigDecimal.ONE; // cosh(0) = 1
        assertEquals(expected, Cosh.getCosh(x));

        x = new BigDecimal("1");
        expected = BigDecimal.valueOf(Math.cosh(1)); // cosh(1)
        assertEquals(expected, Cosh.getCosh(x));

        x = new BigDecimal("-1");
        expected = BigDecimal.valueOf(Math.cosh(-1)); // cosh(-1) = cosh(1)
        assertEquals(expected, Cosh.getCosh(x));
    }

    @Test
    public void testGetTaylorCosh() {
        BigDecimal x = new BigDecimal("0");
        int k = 10; // Количество членов ряда
        BigDecimal expected = BigDecimal.ONE; // cosh(0) = 1
        assertEquals(expected, Cosh.getTaylorCosh(x, k));

        x = new BigDecimal("1");
        expected = BigDecimal.valueOf(Math.cosh(1)); // cosh(1)
        assertEquals(expected.setScale(5, BigDecimal.ROUND_HALF_UP),
                Cosh.getTaylorCosh(x, k).setScale(5, BigDecimal.ROUND_HALF_UP));

        x = new BigDecimal("-1");
        expected = BigDecimal.valueOf(Math.cosh(-1)); // cosh(-1) = cosh(1)
        assertEquals(expected.setScale(5, BigDecimal.ROUND_HALF_UP),
                Cosh.getTaylorCosh(x, k).setScale(5, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testGetSigma() {
        int k = 3;
        BigDecimal expected = new BigDecimal("0.001");
        assertEquals(expected, Cosh.getSigma(k));

        k = 0;
        expected = BigDecimal.ONE; // 10^0 = 1
        assertEquals(expected, Cosh.getSigma(k));
    }
}
