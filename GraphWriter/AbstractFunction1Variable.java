package GraphWriter;

import static java.lang.System.arraycopy;

import java.util.Vector;

/**
 * AbstractFunction1Variable is abstraction
 * which can be used for graph rendering.
 * 
 * <p>
 * USING:
 * </p>
 * <p>
 * 1 + 2
 * </p>
 * <p>
 * 1 or 1.2 or 1,2 is numbers
 * </p>
 * <p>
 * 1 - 2
 * </p>
 * <p>
 * 1 * 2
 * </p>
 * <p>
 * 1 / 2
 * </p>
 * <p>
 * 1 // 2
 * </p>
 * <p>
 * 2x
 * </p>
 * <p>
 * ( )
 * </p>
 * <p>
 * 2(...) or (...)2 means 2 * (...) or (...) * 2
 * </p>
 * <p>
 * 2 ^ 10 means raising 2 to power 10
 * </p>
 * <p>
 * 3 % 2 means 3 mod 2
 * </p>
 * <p>
 * |2| means absolute value of 2
 * </p>
 * <p>
 * log3(9) means logarithm base 3 of 9
 * </p>
 */
public abstract class AbstractFunction1Variable implements Function1Variable {
    private final String[] components;

    /**
     * Generate function.
     * 
     * @see README.md
     * @param expression
     */
    public AbstractFunction1Variable(String expression) {
        expression = removeExtraSpaces(expression);
        expression = addRequiredSpaces(expression);

        components = convertToComponents(expression);
    }

    /**
     * Generate value of function in assigned {@code x}.
     * 
     * @param x
     * @return value of f(x)
     */
    @Override
    public double getValue(double x) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Removes all double spaces.
     * 
     * @param expression
     * @return processed string
     */
    protected static String removeExtraSpaces(String expression) {
        Vector<Integer> indexesToRemove = new Vector<>();
        indexesToRemove.addAll(getIndexesOfDoubleSpaces(expression));
        indexesToRemove.addAll(getIndexesOfStartEndSpaces(expression));
        indexesToRemove.addAll(getIndexesOfSpacesInNumbers(expression));
        indexesToRemove.addAll(getIndexesOfExtraSpacesNearBrackets(expression));

        expression = removeIndexesFromString(expression, indexesToRemove);

        return expression;
    }

    /**
     * Adds required spaces.
     * {@code "1+1"} -> {@code "1 + 1"}
     *
     * @param expression
     * @return processed string
     */
    protected static String addRequiredSpaces(String expression) {
        // TODO: create
        return null;
    }

    /**
     * Convert string to components.
     * Spaces shouldn't be before closing and after opening brackets.
     * All other components should be divided by only one spaces.
     * 
     * @param expression
     * @return
     */
    protected static String[] convertToComponents(String expression) {
        // TODO: create
        return null;
    }

    /**
     * Returns vector contains indexes of all double spaces in {@code expression}.
     * Index'es order should be considered accidental.
     * Result can contains one index twice or more.
     * 
     * @param expression
     * @return vector of indexes
     */
    protected static Vector<Integer> getIndexesOfDoubleSpaces(String expression) {
        Vector<Integer> result = new Vector<>();
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == ' '
                    && expression.charAt(i - 1) == ' ') {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Returns vector contains indexes of all start or end spaces in
     * {@code expression}.
     * Index'es order should be considered accidental.
     * Result can contains one index twice or more.
     * 
     * @param expression
     * @return vector of indexes
     */
    protected static Vector<Integer> getIndexesOfStartEndSpaces(String expression) {
        if (expression == "") {
            return new Vector<>();
        }

        Vector<Integer> result = new Vector<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ' ') {
                result.add(i);
            }
        }
        for (int i = expression.length() - 1; i > -1; i--) {
            if (expression.charAt(i) == ' ') {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Returns vector contains indexes of all extra spaces near brackets in
     * {@code expression}.
     * Index'es order should be considered accidental.
     * Result can contains one index twice or more.
     * 
     * @param expression
     * @return vector of indexes
     */
    protected static Vector<Integer> getIndexesOfExtraSpacesNearBrackets(String expression) {
        // TODO: create
        Vector<Integer> result = new Vector<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                int j;
                for (j = i + 1; j < expression.length(); j++) {
                    if (expression.charAt(j) == ' ') {
                        result.add(j);
                    } else {
                        break;
                    }
                }
                i = j;
            }
        }

        for (int i = expression.length() - 1; i > -1; i--) {
            if (expression.charAt(i) == ')') {
                int j;
                for (j = i - 1; j > -1; j--) {
                    if (expression.charAt(j) == ' ') {
                        result.add(j);
                    } else {
                        break;
                    }
                }
                i = j;
            }
        }

        return result;
    }

    /**
     * Returns vector contains indexes of all extra spaces inside numbers
     * {@code ("1 23 4444")} in {@code expression}.
     * Index'es order should be considered accidental.
     * Result can contains one index twice or more.
     * 
     * @param expression
     * @return vector of indexes
     */
    protected static Vector<Integer> getIndexesOfSpacesInNumbers(String expression) {
        // TODO: create
        return null;
    }

    /**
     * Return string without all chars at {@code indexes}.
     * {@code indexes} is vector which can contains one index twice or more.
     * Index'es order can be accidental.
     * 
     * @param expression
     * @param indexes
     * @return
     */
    protected static String removeIndexesFromString(String expression, Vector<Integer> indexes) {
        String result = "";
        for (int i = 0; i < expression.length(); i++) {
            if (!indexes.contains(i)) {
                result += expression.charAt(i);
            }
        }

        return result;
    }

    /**
     * Append {@code element} to the and of {@code array}.
     * 
     * @param array
     * @param element
     * @return new array
     */
    protected static String[] appendToArray(String[] array, String element) {
        String[] newArray = new String[array.length + 1];
        arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;

        return newArray;
    }
}
