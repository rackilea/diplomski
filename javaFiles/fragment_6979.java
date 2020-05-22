public static Date[] getDaysOfWeek(Date refDate, int firstDayOfWeek) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(refDate);
    calendar.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);
    calendar.set(Calendar.WEEK_OF_YEAR, calendar.get(Calendar.WEEK_OF_YEAR) - 1);
    Date[] daysOfWeek = new Date[7];
    for (int i = 0; i < 7; i++) {
        daysOfWeek[i] = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
    }
    return daysOfWeek;
}