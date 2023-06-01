package Tests;

import java.util.Vector;

import GraphWriter.AbstractFunction1Variable;

/**
 * AbstractFunction1Variable
 */
public class AbstractFunction1VariableStub extends AbstractFunction1Variable {

    public AbstractFunction1VariableStub(String mathematicalExpression) {
        super(mathematicalExpression);
    }

    public static String removeExtraSpaces(String expression) {
        return AbstractFunction1Variable.removeExtraSpaces(expression);
    }

    public static String[] convertToComponents(String expression) {
        return AbstractFunction1Variable.convertToComponents(expression);
    }

    public static String[] appendToArray(String[] array, String element) {
        return AbstractFunction1Variable.appendToArray(array, element);
    }

    public static Vector<Integer> getIndexesOfDoubleSpaces(String expression) {
        return AbstractFunction1Variable.getIndexesOfDoubleSpaces(expression);
    }

    public static Vector<Integer> getIndexesOfStartEndSpaces(String expression) {
        return AbstractFunction1Variable.getIndexesOfStartEndSpaces(expression);
    }

    public static Vector<Integer> getIndexesOfSpacesInNumbers(String expression) {
        return AbstractFunction1Variable.getIndexesOfSpacesInNumbers(expression);
    }

    public static Vector<Integer> getIndexesOfExtraSpacesNearBrackets(String expression) {
        return AbstractFunction1Variable.getIndexesOfExtraSpacesNearBrackets(expression);
    }

    public static String removeIndexesFromString(String string, Vector<Integer> indexes) {
        return AbstractFunction1Variable.removeIndexesFromString(string, indexes);
    }
}