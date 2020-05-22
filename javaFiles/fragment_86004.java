public class Calculator {

    public static void main(String[] args) {
        display(2, '+', 3, 5);
        displaySafe(2, '+', 3, 5);
    }

    public static void display(int num1, char operator, int num2, int result) {
        System.out.println(num1 + operator + num2 + '=' + result);
    }

    public static void displaySafe(int num1, char operator, int num2, int result) {
        System.out.println(Integer.toString(num1) + operator + Integer.toString(num2) + "=" + result);
    }

}