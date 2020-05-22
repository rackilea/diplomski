import java.util.Scanner;

public class Problem1 {
    static int x = 0;
    static int counter = 0;

    // input
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(recursive(s));

    }

    // recursive method
    public static int recursive(String s) {
        if (s.length() == 1) {
            x = (x * 10) + Integer.parseInt(s.substring(0, 1));
            return x;
        } else {
            x = (x * 10) + Integer.parseInt(s.substring(0, 1));
            counter++;
            return recursive(s.substring(1, s.length()));

        }

    }
}