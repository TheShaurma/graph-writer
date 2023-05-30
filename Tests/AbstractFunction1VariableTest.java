package Tests;

import java.util.Random;
import static java.lang.Math.pow;
import static java.lang.Math.abs;
import static java.lang.Math.log;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * AbstractFunction1VariableTest
 */
public class AbstractFunction1VariableTest {
    private final static Random random = new Random();

    @Test
    public void getValue_nPlusDifferentX_rightValuesReturned() {
        final double n = 2000 * random.nextDouble() - 1000;
        double x = 2000 * random.nextDouble() - 1000;
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub(n + " + x");

        for (int i = 0; i < 1000; i++) {
            expected = n + x;
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_nMinusDifferentX_rightValuesReturned() {
        final double n = 2000 * random.nextDouble() - 1000;
        double x = 2000 * random.nextDouble() - 1000;
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub(n + " - x");

        for (int i = 0; i < 1000; i++) {
            expected = n - x;
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_nMultiplyDifferentX_rightValuesReturned() {
        final double n = 2000 * random.nextDouble() - 1000;
        double x = 2000 * random.nextDouble() - 1000;
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub(n + " * x");

        for (int i = 0; i < 1000; i++) {
            expected = n * x;
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_nDivDifferentX_rightValuesReturned() {
        final double n = 2000 * random.nextDouble() - 1000;
        double x = 2000 * random.nextDouble() - 1000;
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub(n + " / x");

        for (int i = 0; i < 1000; i++) {
            expected = n / x;
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_nIntegerDivDifferentX_rightValuesReturned() {
        final double n = 2000 * random.nextDouble() - 1000;
        double x = 2000 * random.nextDouble() - 1000;
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub(n + " // x");

        for (int i = 0; i < 1000; i++) {
            expected = (int) (n / x);
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_nx_rightValuesReturned() {
        final double n = 2000 * random.nextDouble() - 1000;
        double x = 2000 * random.nextDouble() - 1000;
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub(n + "x");

        for (int i = 0; i < 1000; i++) {
            expected = n * x;
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_nPlusDifferentXInBracketsMultiplyM_rightValuesReturned() {
        final double n = 2000 * random.nextDouble() - 1000;
        final double m = 2000 * random.nextDouble() - 1000;
        double x = 2000 * random.nextDouble() - 1000;
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub("(" + n + " + x) * " + m);

        for (int i = 0; i < 1000; i++) {
            expected = (n + x) * m;
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_nPowerDifferentX_rightValuesReturned() {
        final double n = 2000 * random.nextDouble() - 1000;
        double x = 2000 * random.nextDouble() - 1000;
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub(n + "^ x");

        for (int i = 0; i < 1000; i++) {
            expected = pow(n, x);
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_nRemainderFromDivDifferentX_rightValuesReturned() {
        final double n = 2000 * random.nextDouble() - 1000;
        double x = 2000 * random.nextDouble() - 1000;
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub(n + " % x");

        for (int i = 0; i < 1000; i++) {
            expected = n % x;
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_moduleOfX_rightValuesReturned() {
        final double n = 2000 * random.nextDouble() - 1000;
        double x = 2000 * random.nextDouble() - 1000;
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub("|x|");

        for (int i = 0; i < 1000; i++) {
            expected = abs(x);
            actual = function.getValue(x);
            x++;
            x *= -1;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_logarithmBasePositiveNOfPositiveX_rightValuesReturned() {
        final double n = 1000 * random.nextDouble();
        double x = 1000 * random.nextDouble();
        double expected, actual;
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub("log" + n + "(x)");

        for (int i = 0; i < 1000; i++) {
            expected = customLog(n, x);
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    @Test
    public void getValue_expressionWithoutAnySpaces_rightValuesReturned() {
        double x = 2000 * random.nextDouble() - 1000;
        final int n = random.nextInt(2000) - 1000;
        final int m = random.nextInt(2000) - 1000;
        final int c = random.nextInt(2000) - 1000;
        final int h = random.nextInt(2000) - 1000;
        double expected, actual;
        // expression: (n + m - c - h) * x
        final AbstractFunction1VariableStub function = new AbstractFunction1VariableStub(
                "(" + n + "+ " + m + "               " + "-" + c + "                             -" + h
                        + "      )   *    x");

        for (int i = 0; i < 1000; i++) {
            expected = (n + m - c - h) * x;
            actual = function.getValue(x);
            x++;

            assertEquals(expected, actual);
        }
    }

    /**
     * Returns logarithm base {@code base} of {@code value}
     *
     * @param base
     * @param value
     * @return double value of logarithm base {@code base} of {@code value}
     */
    public static double customLog(double base, double value) {
        return log(value) / log(base);
    }
}