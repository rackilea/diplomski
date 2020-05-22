import java.util.Scanner;

public class test {
    public static void main(String args[]) {
        System.out.print("vlozte hmotnost: ");
        Scanner vstup = new Scanner(System.in);
        double hmotnost = vstup.nextDouble();

//------------------------------------------

        System.out.print("vlozte drahu: ");
        double draha = vstup.nextDouble();

//------------------------------------------

        double sila = hmotnost * 10;

//------------------------------------------

        double praca = sila * draha;
        System.out.print("praca je: ");
        System.out.print(praca);
        System.out.println(" Joulov");
    }
}