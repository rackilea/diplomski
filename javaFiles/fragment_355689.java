// File 1
package py4j.examples;

public interface Operator {
        public int doOperation(int i, int j);
        public int doOperation(int i, int j, int k);
}

// File 2
package py4j.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import py4j.GatewayServer;

public class OperatorExample {

    // To prevent integer overflow
    private final static int MAX = 1000;

    public List<Integer> randomBinaryOperator(Operator op) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(random.nextInt(MAX));
        numbers.add(random.nextInt(MAX));
        numbers.add(op.doOperation(numbers.get(0), numbers.get(1)));
        return numbers;
    }
}