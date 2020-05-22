public static String getCustomDateScoreboard(String dateTimeStr) {
    Date date = null;
    String formattedTime = "";

    try {
        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(dateTimeStr);
        Log.d(TAG,date.toString());
        formattedTime = new SimpleDateFormat("dd-MM-yyyy hh:mm aa", Locale.US).format(date);
    } catch (ParseException e) {
        Timber.e(e, "date time not in proper format: %s", dateTimeStr);
    }
    return formattedTime;
}