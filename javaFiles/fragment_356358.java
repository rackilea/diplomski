import java.util.Random;

public class Main {

    public static final int FUNCTION_NUMBER = 3;

    public static String functionA() {
        return "A";
    }

    public static String functionB() {
        return "B";
    }

    public static String functionC() {
        return "C";
    }

    public static String callFunction(int function_index) {
        switch (function_index) {
            case 0: return functionA();
            case 1: return functionB();
            case 2: return functionC();
            default: throw new IllegalArgumentException("Incorrect value for function_index");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        int n = random.nextInt((FUNCTION_NUMBER * FUNCTION_NUMBER) - FUNCTION_NUMBER);
        int name_function_index = n / FUNCTION_NUMBER;
        int phone_no_function_index = n % FUNCTION_NUMBER;

        System.out.print(callFunction(name_function_index));
        System.out.print(callFunction(phone_no_function_index));
        System.out.println("--------------");

    } 

}