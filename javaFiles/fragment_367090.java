import java.util.*;

public class LeapYear
{
    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);
        boolean isFour;
        boolean isQuit = true;
        int checkedYear = 2000;
        int minimumAcceptedYear = 1582;

        //System.out.println("Enter a year to check if it  is a leap year");
        do {
            do {
                System.out.println("Enter a year to check if it is a leap year");
                checkedYear = input.nextInt();
                if ( checkedYear < minimumAcceptedYear ) {
                    System.out.println("That year is too old, choose a year in more recent history");
                }
            } while ( checkedYear < minimumAcceptedYear );

            isFour = (checkedYear % 4) == 0;

            if ( isFour ) {
                System.out.println("The year is a leap year");
            } else {
                System.out.println("The year is not a leap year");
            }

            System.out.println("DO YOU WANT TO QUIT: (true/false) ?");

            if ( input.hasNextBoolean() ) {     
                isQuit = input.nextBoolean();
            } else {
                        System.out.println("That is neither a true or false.");
            }
        } while ( !isQuit );
    }
}