import java.util.Scanner;

public class A9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a phrase: ");
        String str = in.nextLine();
        printVowels(str);

    }

    public static void printVowels(String str) {
        String a = "";
        String e = "";
        String i = "";
        String o = "";
        String u = "";
        for (int ind = 0; ind < str.length(); ind++) {
            switch (str.charAt(ind)) {
                case 'a':
                case 'A':
                    a += "* ";
                    break;
                case 'e':
                case 'E':
                    e += "* ";
                    break;
                case 'i':
                case 'I':
                    i += "* ";
                    break;
                case 'o':
                case 'O':
                    o += "* ";
                    break;
                case 'u':
                case 'U':
                    u += "* ";
                    break;
            }
        }
        System.out.println("a: " + a);
        System.out.println("e: " + e);
        System.out.println("i: " + i);
        System.out.println("o: " + o);
        System.out.println("u: " + u);
    }
}