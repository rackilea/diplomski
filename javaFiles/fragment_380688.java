public void askForDate(Scanner in) {
    System.out.println("Please enter the date that the vehicle entered the car park in this format dd/mm/yyyy :");

    int day, month, year;
    String[] dateEnteredSplit = in.nextLine().split("/");

    //Assigning each element and converting them to integers.
    day = Integer.parseInt(dateEnteredSplit[0]);
    month = Integer.parseInt(dateEnteredSplit[1]);
    year = Integer.parseInt(dateEnteredSplit[2]);

    if (!(day >= 1 && day <= 31) || !(month >= 1 && month <= 12) || !(year > 1000 && year < 5000)) askForDate(in);

    // You need to save day/month/year variables to other than local scope (like this.day = day)
    // Otherwise it would just somewhere in recursion stack and you wouldn't be able to use it
}