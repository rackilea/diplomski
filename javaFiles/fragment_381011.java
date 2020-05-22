public static void main(String[] args) throws ParseException {
    Date myDate = new Date(); // today
    System.out.println(dayOfWeek(myDate));
    myDate = new SimpleDateFormat("dd.MM.yyyy").parse("15.09.2014"); // tomorrow
    System.out.println(dayOfWeek(myDate));
}

private static int dayOfWeek(Date myDate) {
    Calendar cal = Calendar.getInstance();
    cal.setFirstDayOfWeek(Calendar.MONDAY);
    cal.setTime(myDate);
    return cal.get(Calendar.WEEK_OF_MONTH);
}