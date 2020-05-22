import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Subtitles {

    public static void sortAlfabetical(String x[]) {
        int j;
        boolean found = true; // will determine when the sort is finished
        String temp;

        while (found) {
            found = false;
            for (j = 0; j < x.length - 1; j++) {
                if (x[j].compareToIgnoreCase(x[j + 1]) > 0) { // ascending sort
                    temp = x[j];
                    x[j] = x[j + 1]; // swap
                    x[j + 1] = temp;
                    found = true;
                }
            }
        }

        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }



    public static void compare(String[] arrayOne) {

        Arrays.sort(arrayOne, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String s : arrayOne) {
            System.out.print(s + " ");
        }

    }




    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amountStrings = 3;
        String[] subtitles = new String[amountStrings];
        System.out.println("insert ");
        for (int i = 0; i < amountStrings; i++) {
            subtitles[i] = scan.next();
        }

        System.out.println("--------");


        System.out.print("Sorting alphabetical: ");
        sortAlfabetical(subtitles);
        System.out.println();


        System.out.println("===========================");
        System.out.print("Sorting by word length: ");
        compare(subtitles);


    }
}