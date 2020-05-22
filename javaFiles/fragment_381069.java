import java.util.Scanner;

public class UnitConversion3b {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String maxInputWarning = "\nError: Too many input characters."
                + "\nProgram is now terminating.";
        String lengthOrWeight;
        final double LENGTH_CONVERSION_FACTOR = 3.2808399;
        final double WEIGHT_CONVERSION_FACTOR = 2.20462;
        String whichWeightConversion = "empty", whichLengthConversion = "empty";
        double feet = 0, meters = 0, pounds = 0, kilograms = 0;
        double metersConvertedToFeet, feetConvertedToMeters;
        double poundsConvertedToKilograms, kilogramsConvertedToPounds;

        System.out.println("");
        System.out.print("What kind of value would you like to convert?");
        System.out.print("\nEnter L for length, or W for weight: ");

        lengthOrWeight = keyboard.nextLine();
        if (lengthOrWeight.length() > 1) {
            System.out.println(maxInputWarning);
            System.out.print("Press Enter to continue ... ");
            keyboard.nextLine();
            return;
        } else if ((!(lengthOrWeight.equalsIgnoreCase("l")) && (!(lengthOrWeight
                .equalsIgnoreCase("w"))))) {
            System.out.println("\nError: Unrecognized conversion type."
                    + "\nProgram is now terminating.");
            System.out.print("Press Enter to continue ... ");
            keyboard.nextLine();
            return;
        } else if (lengthOrWeight.equalsIgnoreCase("l")) {
            System.out.println("\nConverting feet or meters?");
            System.out.print("Enter F to convert feet, or M for meters: ");
            whichLengthConversion = keyboard.nextLine();

            if (whichLengthConversion.length() > 1) {
                System.out.println(maxInputWarning);
                System.out.print("Press Enter to continue ... ");
                keyboard.nextLine();
                return;
            } else if ((!(whichLengthConversion.equalsIgnoreCase("f")) && (!(whichLengthConversion
                    .equalsIgnoreCase("m"))))) {
                System.out.println("\nError: Unrecognized unit of "
                        + "measurement.\nProgram is now terminating.");
                System.out.print("Press Enter to continue ... ");
                keyboard.nextLine();
                return;
            } else if (whichLengthConversion.equalsIgnoreCase("f")) {
                System.out.print("Enter the number of feet to"
                        + " convert to meters: ");
                feet = keyboard.nextDouble();
                feetConvertedToMeters = feet / LENGTH_CONVERSION_FACTOR;
                System.out.println(feet + " Feet in Meters is "
                        + feetConvertedToMeters + ".");
                keyboard.nextLine();
                System.out.print("Press Enter to continue ... ");
                keyboard.nextLine();
                return;
            } else if (whichLengthConversion.equalsIgnoreCase("m")) {
                System.out.print("Enter the number of meters to"
                        + " convert to feet: ");
                meters = keyboard.nextDouble();
                metersConvertedToFeet = meters * LENGTH_CONVERSION_FACTOR;
                System.out.println(meters + " Meters in Feet is "
                        + metersConvertedToFeet + ".");
                keyboard.nextLine();
                System.out.print("Press Enter to continue ... ");
                keyboard.nextLine();
                return;
            }
        }

        else {
            System.out.println("Converting pounds or kilograms?");
            System.out.print("Enter P to convert pounds, or K for kilograms: ");
            whichWeightConversion = keyboard.nextLine();

            if (whichWeightConversion.length() > 1) {
                System.out.println(maxInputWarning);
                System.out.print("Press Enter to continue ... ");
                keyboard.nextLine();
                return;
            } else if ((!(whichWeightConversion.equalsIgnoreCase("p")) && (!(whichWeightConversion
                    .equalsIgnoreCase("k"))))) {
                System.out.println("\nError: Unrecognized unit of "
                        + "measurement.\nProgram is now terminating.");
                System.out.print("Press Enter to continue ... ");
                return;
            } else if (whichWeightConversion.equalsIgnoreCase("p")) {
                System.out.println("Enter the number of pounds to"
                        + " convert to kilograms:");
                pounds = keyboard.nextDouble();
                poundsConvertedToKilograms = pounds / WEIGHT_CONVERSION_FACTOR;
                System.out.println(pounds + " Pounds in Kilograms is "
                        + poundsConvertedToKilograms + ".");
                keyboard.nextLine();
                System.out.print("Press Enter to continue ... ");
                keyboard.nextLine();
                return;
            } else if (whichWeightConversion.equalsIgnoreCase("k")) {
                System.out.print("Enter the number of kilograms to"
                        + " convert to pounds: ");
                kilograms = keyboard.nextDouble();
                kilogramsConvertedToPounds = kilograms
                        * WEIGHT_CONVERSION_FACTOR;
                System.out.println(kilograms + " Kilograms in Pounds is "
                        + kilogramsConvertedToPounds + ".");
                keyboard.nextLine();
                System.out.print("Press Enter to continue ... ");
                keyboard.nextLine();
                return;

            }
        }
    }
}