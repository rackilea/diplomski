public void askForDate(Scanner in) {
    System.out.println("Please enter the date that the vehicle entered the car park in this format dd/mm/yyyy :");

    int day, month, year;
    do { // We use do-while to get the first read without condition, although setting date to invalid value (like day = 0) and then running standard while loop will work just as fine
        String[] dateEnteredSplit = in.nextLine().split("/");

        //Assigning each element and converting them to integers.
        day = Integer.parseInt(dateEnteredSplit[0]);
        month = Integer.parseInt(dateEnteredSplit[1]);
        year = Integer.parseInt(dateEnteredSplit[2]);
    } while (!(day >= 1 && day <= 31) || !(month >= 1 && month <= 12) || !(year > 1000 && year < 5000));

    // Now day month and year variables are set correctly and we can do stuff with it
}