public static void main(String[] args) {
    // TODO: validate user-input

    // Input by user:
    int inputDayOfWeek = 3; // Tuesday
    int inputWeekOfMonth = 2;

    if(isInNextMonth(inputDayOfWeek, inputWeekOfMonth)){
        Date outputDate = calculateNextValidDate(inputDayOfWeek, inputWeekOfMonth);

        // Do something with the outputDate
        System.out.println(outputDate.toString());
    }
}

private static boolean isInNextMonth(int inputDayOfWeek, int inputWeekOfMonth){
    // Current day:
    Calendar cal = Calendar.getInstance();
    int currentDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    int currentWeekOfMonth = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);

    // The date has gone past in the current month
    // OR though it's the same week of the month, the day of the week is past the current day of the week
    return inputWeekOfMonth < currentWeekOfMonth || ((inputWeekOfMonth == currentWeekOfMonth) && inputDayOfWeek < currentDayOfWeek);
}