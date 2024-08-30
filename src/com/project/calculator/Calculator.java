package com.project.calculator;

import com.project.enums.Operation;  // Import the Operation enum


import java.util.*;
import java.util.function.BiFunction;

public class Calculator {
    private final Map<Operation, BiFunction<Number, Number, Number>> operations = new HashMap<>();

    public Calculator() {
        operations.put(Operation.ADD, (num1, num2) -> num1.doubleValue() + num2.doubleValue());
        operations.put(Operation.SUBTRACT, (num1, num2) -> num1.doubleValue() - num2.doubleValue());
        operations.put(Operation.MULTIPLY, (num1, num2) -> num1.doubleValue() * num2.doubleValue());
        operations.put(Operation.DIVIDE, (num1, num2) -> {
            if (num2.doubleValue() == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return num1.doubleValue() / num2.doubleValue();
        });
    }

    public Number calculate(Operation op, Number num1, Number num2) {
        if (!operations.containsKey(op)) {
            throw new UnsupportedOperationException("Operation not supported");
        }
        return operations.get(op).apply(num1, num2);
    }

    public void addOperation(Operation op, BiFunction<Number, Number, Number> operation) {
        operations.put(op, operation);
    }

    public Number chainCalculate(Number initialValue, Map<Operation, Number> operationsChain) {
        Number result = initialValue;
        for (Map.Entry<Operation, Number> entry : operationsChain.entrySet()) {
            result = calculate(entry.getKey(), result, entry.getValue());
        }
        return result;
    }
}
