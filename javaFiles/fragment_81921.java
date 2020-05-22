for (double i = 0; i <= colNumberWithTop; i++) {
    //printing the top column
    if (i == 0){
     System.out.printf("%-10s", "Interest Rate");  
     for (double k = 0; k <= rowNumber; k++) {
         currentYears = (firstYears + (incYears * i));
         System.out.printf("%10s", currentYears + " Years");
     }
     System.out.println(); 
    } else if (i > 0) {
      //finding annual interest rate for printing, and monthly interest rate as a decimal for math
      currentAnnInt = (startAnnInt + (incRate * i));
      currentMonthInt = ((currentAnnInt/100)/12);
      System.out.printf("%10.2f%%", currentAnnInt*100);
      for (double k = 0; k <= rowNumber; k++) {
           monthsToPay = (startMonthInt + (monthIncRate * i));
           annuityAmt = annuityCalc(currentMonthInt, monthsToPay);
           currentPayment = (loanAmt * annuityAmt);
           System.out.printf("%10.2f", currentPayment);
      }
      System.out.println();