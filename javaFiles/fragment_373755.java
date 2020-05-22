public static String format(GregorianCalendar calendar) {
    SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
    fmt.setCalendar(calendar);
    String dateFormatted = fmt.format(calendar.getTime());

    return dateFormatted;
}