public static void main(String [] args) {
    //Constant
    final double TAX_RATE = 0.0675;      
    final double TIP_PERCENT = 0.15;

    //Variables                             
    double cost, taxAmount;  // rest of variables

    Scanner keyboard = new Scanner(System.in);

    System.out.print("What is the cost of your meal? ");
    cost = keyboard.nextDouble();

    System.out.println("Your meal cost $" +cost);

    taxAmount = TAX_RATE * cost;
    System.out.println("Your Tax is $" + taxAmount);

    // rest of code

    System.exit(0);
}