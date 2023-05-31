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

    @Override
    public String removeExtraSpaces(String expression) {
        return super.removeExtraSpaces(expression);
    }

    @Override
    public String[] convertToComponents(String expression) {
        return super.convertToComponents(expression);
    }

    public static String[] appendToArray(String[] array, String element) {
        return AbstractFunction1Variable.appendToArray(array, element);
    }

    @Override
    public Vector<Integer> getIndexesOfDoubleSpaces(String expression) {
        return super.getIndexesOfDoubleSpaces(expression);
    }

    @Override
    public Vector<Integer> getIndexesOfStartEndSpaces(String expression) {
        return super.getIndexesOfStartEndSpaces(expression);
    }

    @Override
    public Vector<Integer> getIndexesOfSpacesInNumbers(String expression) {
        return super.getIndexesOfSpacesInNumbers(expression);
    }

    @Override
    public Vector<Integer> getIndexesOfExtraSpacesNearBrackets(String expression) {
        return super.getIndexesOfExtraSpacesNearBrackets(expression);
    }
}