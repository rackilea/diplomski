private static void calculateLoan(Scanner in) {
    //Declare Variables
    double loanNum;
    double rateNum;
    double trateNum;
    double yearNum;
    double monthNum;
    double equNum;
    double outputNum;

    //Prompt for input
    System.out.print("Enter loan amount: ");
    loanNum = Double.parseDouble(in.nextLine());

    System.out.print("Enter rate: ");
    rateNum = Double.parseDouble(in.nextLine());

    System.out.print("Enter number years: ");
    yearNum = Double.parseDouble(in.nextLine());

    //Postive input data check
    if (loanNum <= 0 || rateNum <= 0 || yearNum <= 0) {
        System.out.println("You must enter positive numeric data! ");
        System.exit(0);
    }

    //Convert years to months 
    monthNum = yearNum * 12;

    //Convert rate to percent and monthly
    trateNum = (rateNum / 100) / 12;

    //Complete numerator 
    equNum = Math.pow((1 + trateNum), monthNum);

    //Plug equNum into formula
    outputNum = trateNum * loanNum * (equNum / (equNum - 1));

    System.out.printf("The monthly payment is: $ %.2f%n", outputNum);
}