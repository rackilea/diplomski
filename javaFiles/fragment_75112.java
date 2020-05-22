public static void main(String args[]) {
    double startCredit = 1000;
    double interestRate = 0.015;

    double payInterest = startCredit * interestRate;
    double payDebt = startCredit - payInterest;
    double paid = payInterest + payDebt;
    double newCredit = 965.0;

    int count = 0; // <- While loop counter
    double totalPaidInterest = 0.0; // <- Total should be outside the loop

    while (newCredit > 0) {
      payInterest = newCredit * interestRate;
      payDebt = newCredit - payInterest;
      paid = payInterest + payDebt;
      newCredit = newCredit - paid;
      totalPaidInterest += payInterest;

      // You'd probably don't want to print out TOTAL values at each itteration
      //System.out.println("Total paid interest: " + totalPaidInterest);

      count += 1;
    }

    System.out.print("Total paid interest: ");
    System.out.println(totalPaidInterest);

    System.out.print("Loops: ");
    System.out.println(count);
  }