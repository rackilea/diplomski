private static Date calculateNextValidDate(int inputDayOfWeek, int inputWeekOfMonth){
    // Set the first day of the next month as starting position:
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MONTH, 1);
    cal.set(Calendar.DAY_OF_MONTH, 1);

    // Now first go to the correct week of this month
    int weekOfNextMonth = 1;
    while(weekOfNextMonth < inputWeekOfMonth){
        // Raise by a week
        cal.add(Calendar.DAY_OF_MONTH, 7);
        weekOfNextMonth++;
    }

    // Now that we have the correct week of this month,
    // we get the correct day
    while(cal.get(Calendar.DAY_OF_WEEK) != inputDayOfWeek){
        // Raise by a day
        cal.add(Calendar.DAY_OF_MONTH, 1);
    }

    return cal.getTime();
}