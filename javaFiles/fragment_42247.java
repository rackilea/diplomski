import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna merkkijono: ");

        String merkkijono1 = lukija.nextLine();

        System.out.print("Anna toinen merkkijono: ");

        String merkkijono2 = lukija.nextLine();

        for (int i = 0; i < merkkijono1.length() || i < merkkijono2.length(); i++) {

            if (merkkijono1.length() > i) {
                System.out.print(merkkijono1.charAt(i));

            }
            if (merkkijono2.length() > i) {
                System.out.print(merkkijono2.charAt(i));
            }
        }
    }

}