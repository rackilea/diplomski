private void loadWeather() {
    Date date = new Date(); // This is enough; it uses the current instant.
    DateFormat df = DateFormat.getDateTimeInstance(
        DateFormat.SHORT, DateFormat.SHORT, Locale.getDefault());
    df.setTimeZone(TimeZone.getTimeZone("GMT+0400"));
    String myDate = df.format(date);
    tv_time.setText(myDate);
}