public static String convertDateToCustomFormat(String dateString) {
    DateTimeFormatter dbDateFormat = DateTimeFormat
            .forPattern(("yyyy-MM-dd HH:mm:ss.S"));
    DateTimeFormatter uiDateFormat = DateTimeFormat
            .forPattern("MM/dd/yyyy hh:mm:ss a");
    DateTime date = null;

    date = dbDateFormat.parseDateTime(dateString);

    return uiDateFormat.print(date);
}