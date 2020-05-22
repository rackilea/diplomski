DateFormat dfNy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
dfNy.setTimeZone(TimeZone.getTimeZone("EST"));
DateFormat dfUtc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
dfUtc.setTimeZone(TimeZone.getTimeZone("UTC"));

try {
    return dfUtc.format(dfNy.parse(input));
} catch (ParseException e) {
    return null;              // invalid input
}