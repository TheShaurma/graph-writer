package Tests;

import java.util.Random;
import java.util.Vector;

import static java.lang.Math.pow;
import static java.lang.Math.abs;
import static java.lang.Math.log;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
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

    @Test
    public void appendToArray_appendToArray_appendedToArray() {
        final String[] startArray = { "a", "a", "a", "a" };
        final String[] expected = { "a", "a", "a", "a", "b" };
        String[] actual;
        String element = "b";

        actual = AbstractFunction1VariableStub.appendToArray(startArray, element);

        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void removeExtraSpaces_removeExtraSpaces_extraSpacesRemoved() {
        final String startString = "              3            +                 4           3                           6             4      x                                       ";
        final String expected = "3 + 4364x";

        String actual = AbstractFunction1VariableStub.removeExtraSpaces(startString);

        assertEquals(expected, actual);
    }

    @Test
    public void getIndexesOfDoubleSpaces_getIndexesOfDoubleSpaces_indexesReturned() {
        final String expression = "  x  +    3   ";
        final int[] expected = { 1, 4, 7, 8, 9, 12, 13 };
        Vector<Integer> actual;

        actual = AbstractFunction1VariableStub.getIndexesOfDoubleSpaces(expression);

        assertTrue(identicalElements(expected, actual));
    }

    @Test
    public void getIndexesOfStartEndSpaces_getIndexesOfStartEndSpaces_indexesReturned() {
        final String string = "      1 ";
        final int[] expected = { 0, 1, 2, 3, 4, 5, 7 };
        Vector<Integer> actual;

        actual = AbstractFunction1VariableStub.getIndexesOfStartEndSpaces(string);

        assertTrue(identicalElements(expected, actual));
    }

    @Test
    public void getIndexesOfStartEndSpaces_giveStringFromOnlySpaces_allIndexesReturned() {
        final String string = "            ";
        final int[] expected = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        Vector<Integer> actual;

        actual = AbstractFunction1VariableStub.getIndexesOfStartEndSpaces(string);

        assertTrue(identicalElements(expected, actual));
    }

    @Test
    public void getIndexesOfStartEndSpaces_giveEmptyString_anyIndexesNotReturned() {
        final String string = "";
        Vector<Integer> result;

        result = AbstractFunction1VariableStub.getIndexesOfStartEndSpaces(string);

        assertTrue(result.isEmpty());
    }

    @Test
    public void getIndexesOfExtraSpacesNearBrackets_getIndexesOfExtraSpacesNearBrackets_indexesReturned() {
        final String string = "( 1 +1   *3    )*(  3   ^  4    )";
        final int[] expected = { 1, 11, 12, 13, 14, 18, 19, 28, 29, 30, 31 };
        Vector<Integer> actual;

        actual = AbstractFunction1VariableStub.getIndexesOfExtraSpacesNearBrackets(string);

        assertTrue(identicalElements(expected, actual));
    }

    @Test
    public void getIndexesOfSpacesInNumbers() {
        final String string = "3  2454    35 6       +      43   6 5 4 7  4";
        final int[] expected = { 1, 2, 7, 8, 9, 10, 13, 31, 32, 33, 35, 37, 39, 41, 42 };
        Vector<Integer> actual;

        actual = AbstractFunction1VariableStub.getIndexesOfSpacesInNumbers(string);

        assertTrue(identicalElements(expected, actual));
    }

    //

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

    public static boolean identicalElements(int[] array, Vector<Integer> vector) {
        for (int i : array) {
            if (!vector.contains(i)) {
                return false;
            }
        }
        for (int i : vector) {
            if (!arrayContains(array, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean arrayContains(int[] array, int element) {
        for (int i : array) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }
}