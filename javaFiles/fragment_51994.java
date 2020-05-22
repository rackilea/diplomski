import java.util.Scanner;

public class Kertolasku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Please give a number");

        int first = Integer.valueOf(lukija.nextLine());

        System.out.println("Please give another number");

        int second = Integer.valueOf(lukija.nextLine());

        int v = first*second;

        System.out.println(first + " * " + second + " = " + v);

    }
}