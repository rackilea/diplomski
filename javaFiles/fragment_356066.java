import java.util.Scanner;

public class EtsitynAlkionIndeksi {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int[] taulukko = new int[10];
        taulukko[0] = 6;
        taulukko[1] = 2;
        taulukko[2] = 8;
        taulukko[3] = 1;
        taulukko[4] = 3;
        taulukko[5] = 0;
        taulukko[6] = 9;
        taulukko[7] = 7;

        System.out.print("Mitä etsitään? ");
        int etsittava = Integer.valueOf(lukija.nextLine());

        // Toteuta etsimistoiminnallisuus tänne
        int indeksi = 0;
        while (indeksi < taulukko.length) {
            int arvo = taulukko[indeksi];

            if (etsittava == arvo) {
                System.out.println("Luku " + etsittava + " löytyy indeksistä " + indeksi + ".");
                break;
            }
            indeksi++;
        }
        if (indeksi == taulukko.length) {
            System.out.println("Ei löydy ");
        }
    }
}