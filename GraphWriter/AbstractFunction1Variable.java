package GraphWriter;

import static java.lang.System.arraycopy;

import java.util.Vector;

public abstract class AbstractFunction1Variable implements Function1Variable {
    private final String[] components;

    public AbstractFunction1Variable(String expression) {
        expression = removeExtraSpaces(expression);
        expression = addRequiredSpaces(expression);

        components = convertToComponents(expression);
    }

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
    protected String removeExtraSpaces(String expression) {
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
    protected String addRequiredSpaces(String expression) {
        // TODO: create
        return null;
    }

    protected String[] convertToComponents(String expression) {
        // TODO: create
        return null;
    }

    protected Vector<Integer> getIndexesOfDoubleSpaces(String expression) {
        Vector<Integer> result = new Vector<>();
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == ' '
                    && expression.charAt(i - 1) == ' ') {
                result.add(i);
            }
        }

        return result;
    }

    protected Vector<Integer> getIndexesOfStartEndSpaces(String expression) {
        // TODO: create test: what if give string with only spaces
        Vector<Integer> result = new Vector<>();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < expression.length(); j++) {
                if (expression.charAt(j) == ' ') {
                    result.add(j);
                } else {
                    break;
                }
            }

            expression = new StringBuilder(expression).reverse().toString();
        }

        return result;
    }

    protected Vector<Integer> getIndexesOfExtraSpacesNearBrackets(String expression) {
        // TODO: create
        return null;
    }

    protected String removeIndexesFromString(String expression, Vector<Integer> indexes) {
        String result = "";
        for (int i = 0; i < expression.length(); i++) {
            if (!indexes.contains(i)) {
                result += expression.charAt(i);
            }
        }

        return result;
    }

    protected Vector<Integer> getIndexesOfSpacesInNumbers(String expression) {
        // TODO: create
        return null;
    }

    protected static String[] appendToArray(String[] array, String element) {
        String[] newArray = new String[array.length + 1];
        arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;

        return newArray;
    }
}
