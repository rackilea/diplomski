import java.util.Scanner;

public class Solution {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
       getTextFromUser();
    }

    private static void getTextFromUser() {
       print("Enter Sentence Here: ");
       String text = in.nextLine();

       print("\nDo you want to capitalize words in sentence? Y/N: ");

       while (in.nextLine().equalsIgnoreCase("y")) {
           print("Enter Word: ");
           print("Modified Text: " + changeWord(text, in.nextLine()));
           print("\n\nDo you want to capitalize words in sentence? Y/N");
       }
    }

    private static String changeWord(String text, String word) {
        return text.replaceAll("\\b" + word + "\\b" /* \\b Means word 
        boundary */, word.toUpperCase()); // No validations done.
    }

    private static void print(String message) {
        System.out.print(message);
    }

}