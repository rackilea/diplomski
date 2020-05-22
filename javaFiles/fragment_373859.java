public static String formatDate (String date, String initDateFormat, String endDateFormat) throws ParseException {

    Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
    SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
    String parsedDate = formatter.format(initDate);

    return parsedDate;
}