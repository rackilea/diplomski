public static void yearCalc() {
    Calendar sDateCalendar = Calendar.getInstance(Locale.GERMANY);
    int currentWeek = sDateCalendar.get(Calendar.WEEK_OF_YEAR);
    int currentMonth = sDateCalendar.get(Calendar.MONTH);
    int Year = sDateCalendar.get(Calendar.YEAR);
    if (currentWeek == 1 & currentMonth == 11) {
        Year = Year + 1;
    }

    sDateCalendar.set(Calendar.YEAR, Year);
    sDateCalendar.set(Calendar.WEEK_OF_YEAR, currentWeek);

    sDateCalendar.set(Calendar.DAY_OF_WEEK, 2);

    String a = sDateCalendar.getTime().toString();

    System.out.println(a);

    sDateCalendar.set(Calendar.YEAR, Year);
    sDateCalendar.set(Calendar.WEEK_OF_YEAR, currentWeek);

    sDateCalendar.set(Calendar.DAY_OF_WEEK, 8);
    String b = sDateCalendar.getTime().toString();

    System.out.println(b);
}