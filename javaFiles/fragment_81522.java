import java.util.Scanner;

public class ders1 {

    public static void main(String[] args) {
        // HW3 Topic 3
        Scanner input = new Scanner(System.in);

        String reverse1 = "";
        String reverse2 = "";
        System.out.println("Please enter the first string: ");
        String s1 = input.nextLine();

        System.out.println("Please enter the second string: ");
        String s2 = input.nextLine();

        for (int i = s1.length() - 1; i >= 0; i--) {
            reverse1 = reverse1 + s1.charAt(i);
        }

        for (int i = s2.length() - 1; i >= 0; i--) {
            reverse2 = reverse2 + s2.charAt(i);
        }

        int l1 = reverse1.length();
        int l2 = reverse2.length();

        if (l1 < l2) {
            int l3 = l1;
            System.out.println(reverse1 + " " + reverse2);
            System.out.println(commonSuffix(reverse1, reverse2, l3));
        } else {
            int l3 = l2;
            System.out.println(reverse1 + " " + reverse2);
            System.out.println(commonSuffix(reverse1, reverse2, l3));
        }
    }

    public static String commonSuffix(String reverse1, String reverse2, int l3) {
        String suffixies = "";
        for (int k = 0; k < l3; k++) {
            if (reverse1.charAt(k) != reverse2.charAt(k)) {
                break;
            } else {
                suffixies += reverse1.charAt(k);
            }
        }

        // Reverse again
        String reverse = "";
        for (int i = suffixies.length() - 1; i >= 0; i--) {
            reverse = reverse + suffixies.charAt(i);
        }

        return reverse;
    }
}