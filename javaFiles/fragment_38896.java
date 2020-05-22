// Process Each Customer
public static void PerformTask(String mealName[], double mealPrice[]) throws IOException {
    char userChoice;
    userChoice = GetUserChoice();
    while (userChoice != 'N') {
        ProcessEachCustomer(mealName, mealPrice);
        userChoice = GetUserChoice();
    }
}

// Get User Choice
public static char GetUserChoice() {
    char userChoice;
    Scanner kbd = new Scanner(System.in);
    do {
        System.out.print("Would you like to Order? (Y/N) ");
        userChoice = kbd.nextLine().toUpperCase().charAt(0);
    } while (userChoice != 'Y' && userChoice != 'N');
    return userChoice;
}

// Process Each Customer
public static void ProcessEachCustomer(String mealName[], double mealPrice[]) throws IOException {
    int mealNumber;
    double[] mealTotals = new double[3];
    int[] quantities = new int[3];
    double[] totals;
    ProcessEachMeal(quantities, mealName, mealPrice);
    totals = UpdateMealTotals(mealPrice, mealTotals, quantities);
    DisplayOrderSummary(mealPrice, mealTotals, quantities, totals, mealName);
    LogTransaction(mealPrice, mealTotals, quantities, totals, mealName);
}