import java.util.Scanner;

public class ReverseThree {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String c;
        do {
            System.out.print("Enter Words: ");
            String a = input.nextLine();

            String b = reverseMethod(a);
            System.out.println("Reverse: " + b);

            System.out.print("Try Again?");
            c = input.nextLine();
        } while (c.equalsIgnoreCase("YES"));
        input.close();
    }

    public static String reverseMethod(String a) {
        String b = "";
        for (i = a.length() - 1; i >= 0; i--)
            b = b + a.charAt(i);
        return b;
    }

}