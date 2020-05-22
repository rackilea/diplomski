import java.util.Scanner;

public class lab05a {

    public static void main (String[] args) {
        String statement;
        Scanner scan = new Scanner(System.in);
        int vowela = 0;
        int vowele = 0;
        int voweli = 0;
        int vowelo = 0;
        int vowelu = 0;
        int nonvowel = 0;
        statement = scan.nextLine().toLowerCase();
        for (int i = 0; i < statement.length(); i++) {
            char c = statement.charAt(i);
            switch (c) {
                case 'a':
                    vowela++;
                    break;
                case 'e':
                    vowele++;
                    break;
                case 'i':
                    voweli++;
                    break;
                case 'o':
                    vowelo++;
                    break;
                case 'u':
                    vowelu++;
                    break;
                default:
                    nonvowel++;
                    break;
            }
        }

        System.out.println("a: " + vowela);
        System.out.println("e: " + vowele);
        System.out.println("i: " + voweli);
        System.out.println("o: " + vowelo);
        System.out.println("u: " + vowelu);
        System.out.println("nonvowel: " + nonvowel);
    }
}