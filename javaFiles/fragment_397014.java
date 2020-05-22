while (stdIn.hasNextInt()) {
    dayOfTheWeek = stdIn.nextInt();
    if (dayOfTheWeek == 0) {
        System.out.println("Zero was entered. Exiting");
        break;
    }
    if (dayOfTheWeek < 1 || dayOfTheWeek > 7) {
        System.out.println("Sorry, not a valid number.");
    }
    // do something else with dayOfTheWeek
}