import java.util.*;

public class PartA {

    private final static int A_UPPER_ASCII_NUMBER = 65;
    private final static int A_LOWER_ASCII_NUMBER = 97;

    public static void main(String args[]) {
        PartA one = new PartA();
        String i = one.encode();
        System.out.println(i);
    }

    public String encode() {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        char ch[] = word.toCharArray();
        for (int x = 0; x < ch.length; x++) {

            if (ch[x] >= 'A' && ch[x] <= 'Z') {
                int res = (25 + (A_UPPER_ASCII_NUMBER - ch[x]) * 2);
                ch[x] = (char) (ch[x] + res);
            }

            if (ch[x] >= 'a' && ch[x] <= 'z') {
                int res = (25 + (A_LOWER_ASCII_NUMBER - ch[x]) * 2);
                ch[x] = (char) (ch[x] + res);
            }
        }
        String enc = ch[0] + "";
        return enc;
    }
}