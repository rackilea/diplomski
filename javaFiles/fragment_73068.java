public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);

    System.out.println("Enter today's date");
    System.out.print("Year: ");
    int todayYear = userInput.nextInt();
    System.out.print("Month: ");
    int todayMonth = userInput.nextInt();
    System.out.print("Day: ");
    int todayDay = userInput.nextInt();

    // Java has January as month 0. Let's not require that the user know.
    Calendar today = new GregorianCalendar(todayYear, todayMonth - 1,
            todayDay);

    System.out.println("Enter date of birth");
    System.out.print("Year: ");
    int yearBorn = userInput.nextInt();
    System.out.print("Month: ");
    int monthBorn = userInput.nextInt();
    System.out.print("Day: ");
    int dayBorn = userInput.nextInt();
    Calendar born = new GregorianCalendar(yearBorn, monthBorn - 1, dayBorn);

    double diff = today.getTimeInMillis() - born.getTimeInMillis();
    diff = diff / (24 * 60 * 60 * 1000); // hours in a day, minutes in a hour,
                                    // seconds in a minute, millis in a
                                    // second.
    System.out.println(Math.round(diff));
}