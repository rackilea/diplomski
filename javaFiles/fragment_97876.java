public class Main {

    static class One {
        static int getValue() {
            return 1;
        }
    }

    static class Two {
        static int getValue() {
            return 2;
        }
    }

    static class Calculator {
        static void printResult() {
            int sum = One.getValue() + Two.getValue();
            System.out.println("The sum is " + sum + ".");
        }
    }

    public static void main(String[] args) {
        Calculator.printResult();
    }

}