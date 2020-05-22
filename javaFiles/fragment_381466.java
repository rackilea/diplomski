import java.util.Scanner;

public class LongestString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");

        String word1 = "", word2 = "";
        int l1 = 0, l2 = 0;

        while (sc.hasNext()) {
            word1 = sc.next();

            // type exit finish the loop
            if (word1.equals("exit"))
                break;

            l1 = word1.length();
            if (l1 > l2) {
                l2 = l1;
                word2 = word1;
            }
        }

        sc.close();

        System.out.println("Longest Word: " + word2);
        System.out.println("Length of Word: " + l2);
    }
}