import java.util.Scanner;

public class Bat {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        printString(stringBits(str));
    }

    public static String stringBits(String str) {
        String result = "";
        for (int i = 0; i < str.length();i += 2) {
            result += str.substring(i, i + 1);
        }
        return result;
    }

    public static void printString (String string) {
        System.out.println(string);
    }
}