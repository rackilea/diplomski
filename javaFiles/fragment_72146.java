public static Optional<Date> getDateFromString(String s) {
    Date date = null;
    DateFormat dtF = new SimpleDateFormat("dd/MM/yyyy");
    try {
        date = dtF.parse(s);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return Optional.ofNullable(date);
}