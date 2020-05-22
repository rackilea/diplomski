System.out.print("Please enter the total amount of your bill > \n");
String strBill = scan.nextLine();
boolean validatedBill = false;

  // Validating Bill
  while(!validatedBill) {
    try {
      bill = Double.parseDouble(strBill);
      validatedBill = true;
    } catch(NumberFormatException e) {
      System.out.print("Enter a valid number > \n");
      strBill = scan.nextLine();
    } // end of catch block
  } // end of while loop