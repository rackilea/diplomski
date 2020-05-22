private static final DateFormat DATE_FORMAT =
    new SimpleDateFormat("dd/MM/yy HH:mm");

private String printStandardDate(Date date) {
    return DATE_FORMAT.format(date);
}