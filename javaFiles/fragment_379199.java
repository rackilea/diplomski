public static int getOccurenceOfDayInMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    return calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
}