import java.util.Scanner;

public abstract class StringReverse {
    private static Scanner input;

    public static void main(String[] args){
        System.out.println("Enter a string: ");
        input = new Scanner(System.in);
        String str = input.next();
        System.out.println(new StringBuilder(str).reverse().toString());
    }
}