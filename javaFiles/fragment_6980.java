public static Date[] getPrevious7Days(Date refDate) {
    Calendar calendar = Calendar.getInstance();
    int currentYear = calendar.get(Calendar.YEAR);
    calendar.setTime(refDate);
    calendar.set(Calendar.YEAR, currentYear);
    calendar.add(Calendar.DAY_OF_MONTH, -7);

    Date[] daysOfWeek = new Date[7];
    for (int i = 0; i < 7; i++) {
        daysOfWeek[i] = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
    }
    return daysOfWeek;
}