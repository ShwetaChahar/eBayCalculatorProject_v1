package com.project.calculator;

import com.project.enums.Operation;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorTest {

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        test.runTests();
    }

    private void runTests() {
        testAddition();
        testSubtraction();
        testMultiplication();
        testDivision();
        testDivisionByZero();
        testChainedCalculation();
        testUnsupportedOperation();
        testAddOperation();
    }

    private void assertEqual(Number expected, Number actual, String testName) {
        if (!expected.equals(actual)) {
            System.out.println(testName + " failed: expected " + expected + " but got " + actual);
        } else {
            System.out.println(testName + " passed");
        }
    }

    private void testAddition() {
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(Operation.ADD, 5, 3);
        assertEqual(8.0, result, "testAddition");
    }

    private void testSubtraction() {
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(Operation.SUBTRACT, 5, 3);
        assertEqual(2.0, result, "testSubtraction");
    }

    private void testMultiplication() {
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(Operation.MULTIPLY, 5, 3);
        assertEqual(15.0, result, "testMultiplication");
    }

    private void testDivision() {
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(Operation.DIVIDE, 6, 3);
        assertEqual(2.0, result, "testDivision");
    }

    private void testDivisionByZero() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate(Operation.DIVIDE, 5, 0);
            System.out.println("testDivisionByZero failed: Expected ArithmeticException not thrown");
        } catch (ArithmeticException e) {
            System.out.println("testDivisionByZero passed");
        }
    }

    private void testChainedCalculation() {
        Calculator calculator = new Calculator();
        Map<Operation, Number> operationsChain = new LinkedHashMap<>();
        operationsChain.put(Operation.ADD, 5);
        operationsChain.put(Operation.MULTIPLY, 2);
        Number result = calculator.chainCalculate(1, operationsChain);
        assertEqual(12.0, result, "testChainedCalculation");
    }

    private void testUnsupportedOperation() {
        Calculator calculator = new Calculator();
        try {
            // Assuming Operation.valueOf("UNKNOWN") will throw an exception if it does not exist
            calculator.calculate(Operation.valueOf("UNSUPPORTED"), 5, 3);
            System.out.println("testUnsupportedOperation failed: Expected UnsupportedOperationException not thrown");
        } catch (UnsupportedOperationException e) {
            System.out.println("testUnsupportedOperation passed");
        }
    }

    private void testAddOperation() {
        Calculator calculator = new Calculator();
        // Add a custom operation
        calculator.addOperation(Operation.valueOf("CUSTOM"), (num1, num2) -> num1.doubleValue() + num2.doubleValue() + 10);
        Number result = calculator.calculate(Operation.valueOf("CUSTOM"), 5, 3);
        assertEqual(18.0, result, "testAddOperation");
    }
}