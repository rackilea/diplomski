import java.util.Scanner;

public class Question1 {

    private static String ones[] = {
            "", "ONE", "TWO", "THREE", " FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
            "ELEVEN", "TWELVE", " THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"
    };

    private static String tens[] = {
            " ", " ", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"
    };

    public static void numberToWord(int num, String val) {
        if (num > 19)
            System.out.print(tens[num / 10] + " " + ones[num % 10]);
        else
            System.out.print(ones[num]);

        if (num > 0)
            System.out.println(val);
    }

    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nPlease type a number between 20 and 99 OR type -1 to end: ");
            number = scanner.nextInt();

            if (number == -1)
                break; // Leave the loop

            if (number >= 20 && number <= 99)
                numberToWord(number, " ");
            else
                System.out.print("Out of bounds. Try Again");
        }
    }

}