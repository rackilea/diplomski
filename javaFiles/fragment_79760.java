Scanner scan = new Scanner(System.in);
NumberFormat nf = NumberFormat.getCurrencyInstance();
int salesCount = 0;
double grandTotal = 0, baseSalary = 200;
while (true) {
    // ask for the amount of sales
    System.out.println("Enter sales amount (enter -999 to end): ");
    double sales = scan.nextDouble();
    if (sales == -999) {
        break;
    }
    salesCount++;
    double commission = 0;
    if (sales >= 500 && sales < 1000) {
        commission = ((sales - 500) * .03);
    } else if (sales >= 1000 && sales < 3000) {
        commission = ((500 * .03) + ((sales - 1000) * .05));
    } else if (sales >= 3000) {
        commission = ((500 * .03) + (2000 * .05) + ((sales - 3000) * .08));
    }

    double salesTotal = baseSalary + commission;
    grandTotal += salesTotal;

    System.out.println("You earned " + nf.format(commission) 
            + " in commission for a total $"
            + nf.format(salesTotal) + " salary.\n");
}
System.out.println("The number of sales is " + salesCount 
        + " and the total payout is " + nf.format(grandTotal));