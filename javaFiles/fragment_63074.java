public void computeAndPrintTotalBill(){
    double mealCharge = getMealCharge();
    tax = mealCharge * taxRate;
    tip = mealCharge * tipRate;
    total = mealCharge + tax + tip;
    Test.println("charge: " + mealCharge);
    Test.println("tax: " + tax);
    Test.println("tip: " + tip);
    Test.println("total: " + total);
 }