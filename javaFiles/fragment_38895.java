public static void PerformTask(String mealName[], double mealPrice[]) throws IOException {
    char userChoice;
    // ask for first time
    userChoice = GetUserChoice();
    while (userChoice != 'N') {
        ProcessEachCustomer(mealName, mealPrice);
        // ask again so if user is done (userChoice='N') while-loop will terminate
        userChoice = GetUserChoice();
    }
}