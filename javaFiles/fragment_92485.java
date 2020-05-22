import java.util.Scanner;

public class CPT236PalindromeCheckMethod {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = input.nextLine();

        if (checkPalindrome(s))
            System.out.println(s + " is a palindrome");
        else
            System.out.println(s + " is not a palindrome");
    }

    public static boolean checkPalindrome(String str) {

        String lowerString = str.toLowerCase();
        String resultString = "";

        for (int i = 0; i < lowerString.length(); i++) {
            if (Character.isLetter(lowerString.charAt(i))) {
                resultString = resultString + lowerString.charAt(i);
            }
        }

        int low = 0;

        int high = resultString.length() - 1;

        boolean isPalindrome = true;
        while (low < high) {
            if (resultString.charAt(low) != resultString.charAt(high)) {
                isPalindrome = false;
                break;
            }

            low++;
            high--;

        }
        return isPalindrome;
    }
}