package massilia.export.promotion;

import java.util.Scanner;

public class Q8_PopAndLandArea2 {
    static String pplPerMile = " person/s per square mile.\n";
    static Scanner x = new Scanner(System.in);

    public static void main(String[] args) {
        Q8_PopAndLandArea2 obj = new Q8_PopAndLandArea2();
        obj.countryCaller();
    }

    String userSelected;

    void countryCaller() {
        int i;
        int totalDensity = 0;
        for (i = 0; i < 3; i++) {
            int actualDensity = 0;
            System.out.println("Enter one of these 3 countries: \n1.USA \n2.Canada \n3.Mexico");
            userSelected = x.next();
            if (userSelected.equalsIgnoreCase("USA")) {
                actualDensity = USA();
            } else if (userSelected.equalsIgnoreCase("Canada")) {
                actualDensity = Canada();
            } else if (userSelected.equalsIgnoreCase("Mexico")) {
                actualDensity = Mexico();
            } else {
                System.out.println("I don't understand. Care to try again?");
                String tryAgain2 = x.next();
                if (tryAgain2.equalsIgnoreCase("N")) {
                    return;
                }
            }
            totalDensity += actualDensity;
        }
        System.out.println("The average is" + totalDensity / 3);
    }

    public int USA() {
        System.out.println("Enter the approximate population: ");
        int popUSA = x.nextInt();
        System.out.println("Enter the land area of the country (in sq miles): ");
        int areaUSA = x.nextInt();
        int calcUSA = popUSA / areaUSA;
        System.out.println("The population density of the USA is " + calcUSA + pplPerMile + calcUSA);
        return calcUSA;
    }

    public int Canada() {
        System.out.println("Enter the approximate population: ");
        int popCanada = x.nextInt();
        System.out.println("Enter the land area of the country (in sq miles): ");
        int areaCanada = x.nextInt();
        int calcCanada = popCanada / areaCanada;
        System.out.println("The population density of Canada is" + calcCanada + pplPerMile);
        return calcCanada;
    }

    public int Mexico() {
        System.out.println("Enter the approximate population: ");
        int popMexico = x.nextInt();
        System.out.println("Enter the land area of the country (in sq miles): ");
        int areaMexico = x.nextInt();
        int calcMexicio = popMexico / areaMexico;
        System.out.println("The population density of Mexico is " + calcMexicio + pplPerMile);
        return calcMexicio;
    }

}