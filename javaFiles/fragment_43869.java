import java.util.Scanner;

public class RichterScaleDamage {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String name = "";
        char answer = 'Y';
        double homeValue = 0;
        double richterScale = 0;
        double payout = 0;
        double deductible = 0;
        String coverage = "";

        System.out.printf("\nPlease enter your name:  ");
        name = userInput.nextLine();


        while (Character.toUpperCase(answer) == 'Y') {
            System.out.printf("\nPlease enter the insured value of your home:  ");
            homeValue = userInput.nextDouble();
            userInput.nextLine();

            System.out.printf("\nRichter Scale   Description of Effect"
                    + "\n      8.0       Most structures fall"
                    + "\n      7.0       Many buildings destroyed"
                    + "\n      6.0       Many buildings considerably damaged, some collapse"
                    + "\n      4.5       Damage to poorly constructed buildings"
                    + "\n      3.5       Felt by many people, no destruction"
                    + "\n       0        Generally not felt by people\n\n");

            System.out.printf("\nPlease enter the Richter scale value for the earthquake:  ");
            richterScale = userInput.nextDouble();
            userInput.nextLine();

            if (richterScale < 0) {
                System.out.printf("\nInvalid! Cannot enter negative values");
            }
            System.out.printf("\n\nEnter \'Y\' to continue with another calculation or \'N\' to exit:  ");
            answer = userInput.nextLine().charAt(0);




            if (richterScale >= 8) {
                String message = "Most structures fall";
                payout = homeValue * .85;
                deductible = homeValue * .15;
                coverage += String.format("\n%-50s %6s$%,20.2f"
                        + "\nDeductable%47s %,20.2f"
                        + "\n%46sTOTAL %4s $%,20.2f\n",
                        message, " ", payout, " ", deductible, " ", " ", payout + deductible);

            }
            if (richterScale < 8 && richterScale >= 7) {
                String message = "Many buildings destroyed";
                payout = homeValue * .75;
                deductible = homeValue * .25;
                coverage += String.format("\n%-50s %6s$%,20.2f"
                        + "\nDeductable%47s %,20.2f"
                        + "\n%46sTOTAL %4s $%,20.2f\n",
                        message, " ", payout, " ", deductible, " ", " ", payout + deductible);

            }
            if (richterScale < 7 && richterScale >= 6) {
                String message = "Damage to poorly constructed buildings";
                payout = homeValue * .75;
                deductible = homeValue * .25;
                coverage += String.format("\n%-50s %6s$%,20.2f"
                        + "\nDeductable%47s %,20.2f"
                        + "\n%46sTOTAL %4s $%,20.2f\n",
                        message, " ", payout, " ", deductible, " ", " ", payout + deductible);
            }

            if (richterScale < 6 && richterScale >= 4.5) {
                String message = "Many buildings considerably damaged, some collapse";
                payout = homeValue * .65;
                deductible = homeValue * .35;
                coverage += String.format("\n%-50s %6s$%,20.2f"
                        + "\nDeductable%47s %,20.2f"
                        + "\n%46sTOTAL %4s $%,20.2f\n",
                        message, " ", payout, " ", deductible, " ", " ", payout + deductible);
            }

            if (richterScale < 4.5 && richterScale >= 3.5) {
                String message = "Felt by many people, no destruction";
                payout = homeValue * .55;
                deductible = homeValue * .45;
                coverage += String.format("\n%-50s %6s$%,20.2f"
                        + "\nDeductable%47s %,20.2f"
                        + "\n%46sTOTAL %4s $%,20.2f\n",
                        message, " ", payout, " ", deductible, " ", " ", payout + deductible);
            }

            if (richterScale < 3.5 && richterScale >= 0) {
                String message = "Generally not felt by people";
                payout = homeValue * .0;
                deductible = homeValue * .25;
                coverage += String.format("\n%-50s %6s$%,20.2f"
                        + "\nDeductable%47s %,20.2f"
                        + "\n%46sTOTAL %4s $%,20.2f\n",
                        message, " ", payout, " ", deductible, " ", " ", payout + deductible);
            }

        }
        System.out.printf("%s", coverage);
    }
}