package com.project.main;

import com.project.calculator.Calculator;  // Import the Calculator class
import com.project.enums.Operation;         // Import the Operation enum
import java.util.*;

public class CalculatorMain {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Number addResult = calculator.calculate(Operation.ADD, 5, 3);
        Number subtractResult = calculator.calculate(Operation.SUBTRACT, 10, 4);
        Number multiplyResult = calculator.calculate(Operation.MULTIPLY, 7, 2);
        Number divideResult = calculator.calculate(Operation.DIVIDE, 20, 5);

        System.out.println("Addition (5 + 3): " + addResult);
        System.out.println("Subtraction (10 - 4): " + subtractResult);
        System.out.println("Multiplication (7 * 2): " + multiplyResult);
        System.out.println("Division (20 / 5): " + divideResult);

        Map<Operation, Number> operationsChain = new LinkedHashMap<>();
        operationsChain.put(Operation.ADD, 3);
        operationsChain.put(Operation.MULTIPLY, 2);
        operationsChain.put(Operation.SUBTRACT, 4);

        Number chainResult = calculator.chainCalculate(11, operationsChain);

        System.out.println("Chaining operations on 11 (+3 *2 -4): " + chainResult);

    }
}
