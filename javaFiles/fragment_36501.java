private static boolean purchaseAnother(Scanner stdin)
{
    while (true) {
        System.out.println();
        System.out.println("Purchase another (y/n): ");
        String chk = stdin.nextLine();

        if (chk != null && chk.trim().length() > 0) {
            if (chk.toLowerCase().equals("y")) { return true; }
            if (chk.toLowerCase().equals("n")) { return false; }
        }
    }
}


/**
 * @param args
 *            the command line arguments
 */
public static void main(String[] args)
{
    // declaring scanner name as "typeNumber"
    Scanner typeNumber = new Scanner(System.in);
    System.out.println(
            "::: Welcome to My Java Program To model an ATM machine :::");

    boolean buyMore = true;

    // **ADD: initialize the video list only once
    VideoList();

    // **USE LOCAL VARIABLE FOR COST
    double rentCost = 0.0d;


    while (buyMore) {
        showVideoList();
        System.out.print("Input the serial number of video to buy: ");
        //**ACCUMULATE THE TOTAL COST
        rentCost += buyVideo();
        System.out.printf("Current total $%.2f", rentCost);

        // SEE IF WISH TO KEEP GOING IF THERE IS ANYTHING LEFT TO RENT
        buyMore = (! VTable.isEmpty() && purchaseAnother(typeNumber));
    }

    // actually make a purchase
    // ADD STATEMENT, but this might be in the MMachine class; unknown
    System.out.printf("Charging $%.2f to the Debit Card%n", rentCost);
    MMachine buy = new MMachine();
    buy.Txn(rentCost);


    System.out.println("Have a nice day!");
}