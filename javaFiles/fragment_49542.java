package test;

public class Main {

    public static void main(String[] args) {
        String myString = "$XXYYYU#";
        String xx = myString.substring(1, 3);
        String yyy = myString.substring(3, 6);
        String u = myString.substring(6, 7);
        System.out.println(xx + " " + yyy + " " + u);

    }
}