import java.util.InputMismatchException;
import java.util.Scanner; //PRE-WRITTEN CODE FROM SCANNER CLASS

public class sumOddsPetrantoni {

    public static int limitNumber;

    public static void main(String args[]) // MAIN METHOD USED TO CALL OTHER
                                            // METHODS
    { //
        getLimitNumber(); // USER INPUTS NUMBER TO BE USED AS MAX LIMIT
                            //
        calcSumPrint(); // COMP CALCS ODD #S BETWEEN 1 AND LIMIT NUMBER
                        //
        doAgain(); // ASKS USER IF THEY WANT TO REPEAT THE PROCESS
                    // YES: RETURNS TO getLimitNumber METHOD
                    // NO: TERMINATES PROGRAM
                    //
    } // END OF MAIN METHOD

    public static void getLimitNumber() {

        boolean done = false;

        Scanner input = new Scanner(System.in);

        while (done != true) {
            try {
                System.out.print("Let's add some odd numbers!");
                System.out
                        .print("\nPlease enter the limit number as an integer: ");
                limitNumber = input.nextInt(); // METHOD USED TO INPUT INTEGER
                done = true;
            } // END - TRY SECTION
            catch (Exception message) {
                input.nextLine();
                System.out.println("\nDo you know what an integerer is?");
                System.out.println("The program threw a " + message
                        + " message at me, NOT a real integer.");
                System.out.println("Please try again.\n");

            } // END - CATCH SECTION
        } // END - WHILE LOOP

    } // END - GET LIMIT NUMBER METHOD

    public static void calcSumPrint() { // START - CALC SUM PRINT METOD

        int sum = 0;
        int ctr = 0;
        for (ctr = 1; ctr <= limitNumber; ctr += 2)
            // START - FOR LOOP
            sum = sum + ctr;
        {
            System.out.println("\nThe sum of the odd numbers between 1 and "
                    + limitNumber + " is " + sum + ".");
        } // END - FOR LOOP

    } // END - CALC SUM PRINT METHOD

    public static int getInt(){
        Scanner input = new Scanner(System.in);
        int ans;
        try {

            ans = input.nextInt();
            return ans;
         }
        catch(Exception e){
            System.out.println("Try Again");
            ans = getInt();
        }
        return ans;
    }
    public static void doAgain() { // START - DO AGAIN METHOD

        int ans;
        Scanner input = new Scanner(System.in);
        System.out
                .println("That was aewsome! \nWant to give it another shot? \n(1 to Continue, 0 to Quit): ");

             ans = getInt();

        if (ans == 1) {
            System.out.println("\nLet's rock and roll!");
            getLimitNumber();
            calcSumPrint();
            doAgain();
        }
        else if (ans == 0) {
            System.out.println("Fine, I see how it is...");
        }else{
            throw new IllegalArgumentException("Oops! that's not fair input must be 0 or 1");
        }



    } // END - DO AGAIN METHOD

}