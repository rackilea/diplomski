/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    //Declare variables
    double nInitialPounds = 0;
    double nInitialKilos = 0.0;
    int nWeightSelection = 0;
    double dInitialWeight = 0.0;
    double dFinalWeight = 0.0;
    double nPoundsToKilos = 0.0;
    double nKilosToPounds = 0.0;
    Scanner input = new Scanner(System.in);

    //Display program title
    System.out.println("WEIGHT CONVERSION");

    //Display program option selections
    System.out.println("1. Pounds to kilograms");

    System.out.println("2. Kilograms to pounds");

    //Print blank line to console
    System.out.println("");

    //Prompt user to make selection of desired output
    System.out.println("Please select the type of conversion you would like to make: ");

    //Read selection by user
    nWeightSelection = input.nextInt();


    //Begin while-loop statement
    while (nWeightSelection == 1) {
        //Prompt user to enter the amount of weight to be converted
        System.out.print("Please enter the pounds: ");

        // Read number entered by the user
        dInitialWeight = input.nextDouble();

        //Call weight conversion for Pounds to Kilos
        nPoundsToKilos = poundsToKilos(nInitialKilos, dInitialWeight);

        //Print final weight
        System.out.println(+dInitialWeight + " pounds is " + nPoundsToKilos + " kilograms.");

        break;
    }

    //Call weight conversion for Pounds to Kilos
    //nPoundsToKilos = poundsToKilos(nInitialKilos, nInitialPounds);

    //Call weight conversion for Kilos to Pounds
    nKilosToPounds = kilosToPounds(nInitialPounds, nInitialKilos);

} //end Main method

/**
 * This method converts weight in pounds to kilograms
 *
 * @param nPounds beginning weight in pounds
 * @param nKilos desired output into kilograms
 * @return nFinalWeight final weight in desired output
 */
public static double poundsToKilos(double nKilos, double nPounds) {
    //Declare variables
    double dFinalWeight = 0.0;                    //Final weight conversion from pounds to kilos

    //Calculate weight conversion
    dFinalWeight = nPounds * 2.204;

    return dFinalWeight;

} //end method poundsToKilos

/**
 * This method prints the converted weight to the console
 *
 * @param nPounds beginning weight in pounds
 * @param nKilos desired output into kilograms
 * @return nFinalWeight final weight in desired output
 */
public static double printWeight(double nKilos, double nPounds) {
    //Declare variables
    double dFinalWeight = 0.0;                    //Final weight conversion

    return dFinalWeight;

} //end method printWeight