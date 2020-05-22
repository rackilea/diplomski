import java.util.*;

public class Ideone {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        String sent, accum = "";
        char check, get;
        int len, count = 0;
        System.out.print("Please enter the sentance you want reversed: ");
        sent = input.nextLine();
        len = sent.length();
        for (int i = 0; i < len; i++) {
            check = sent.charAt(len - i - 1);
            count += 1;
            if (check == ' ') {
                for (int p = 0; p < count; p++) {
                    get = sent.charAt(len - p - 1);
                    accum += (get + ' ');
                }
            }
        }
        System.out.println("Reversed: " + accum);
    }
}