import java.util.Scanner;

public class charToText {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text, hexStr;

        System.out.print("Enter some text: ");
        text = input.nextLine();
        System.out.println();
        System.out.println("Hex value");
        String hexText = hexStr(text);
        System.out.println(hexText);
    }

    public static String hexStr(String text) {
        // You need to implement this function
        char chr;
        int ASCII;
        String hexText = "";
        for (int i = 0; i < text.length(); i++) {
            chr = text.charAt(i);
            ASCII = (int) chr;
            hexText += Integer.toHexString(ASCII);

        }

        return hexText;
    }
}