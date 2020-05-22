package reader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System. in );
        int years;
        int minutes;
        String data = null;

        System.out.println("Years to Minutes Converter");
        boolean test = false;

        while (test == false) {
            System.out.print("Insert number of years: ");
            String regex = "\\d+";
            data = reader.next();
            test = data.matches(regex);
            if (test == false) {
                System.out.println("There is a problem try again");
            }
        }
        years = Integer.valueOf(data);

        minutes = years * 525600;

        System.out.print("That is ");
        System.out.print(minutes);
        System.out.print(" in minutes.");

    }

}