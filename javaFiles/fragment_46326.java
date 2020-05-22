import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number");
        //input
        String number = scanner.next();

        System.out.println(Reverse.reversedString(number));

    }

    private static String reversedString(String num) {

        String reverseNumKeeper = "";
        //reverse number with and without negative sign
        for (int i = num.length(); i > 0; i--) {
            reverseNumKeeper += num.charAt(i - 1);
        }

        //check if reverseNumKeeper has a negative sign or not
        if (reverseNumKeeper.contains("-")) {
            return "-" + Integer.parseInt(reverseNumKeeper.replace("-", ""));
        } else {
            return "" + Integer.parseInt(reverseNumKeeper);
        }

    }

}