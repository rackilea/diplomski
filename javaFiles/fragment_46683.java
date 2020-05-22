double bill = 0.0;
double tip = 0.0;

// Taking an input
System.out.println("Please enter the total amount of your bill > ");
String strBill = scan.nextLine();
boolean validatedBill = false;

  // Validating Bill
  while(!validatedBill) {
    try {
      bill = Double.parseDouble(strBill);
      validatedBill = true;
    } catch(NumberFormatException e) {
      System.out.println("Enter a valid number > ");
      strBill = scan.nextLine();
    } // end of catch block
  } // end of while loop

  while(bill < 0) {
    System.out.println("Your bill amount is less then 0, try again > ");
    bill = scan.nextDouble();
  } // end of while loop

  System.out.println("Please enter the tip percentage > ");
  String strTip = scan.nextLine();
  boolean validatedTip = false;

    // Validating Tip
    while(!validatedTip) {
      try {
        tip = Double.parseDouble(strTip);
        validatedTip = true;
      } catch(NumberFormatException e) {
        System.out.println("Enter a valid tip percentage > ");
        strTip = scan.nextLine();
      } // end of catch block
    } // end of while loop

    while(tip < 0) {
      System.out.println("Your tip is below 0, try again > ");
      tip = scan.nextDouble();
    } // end of while loop