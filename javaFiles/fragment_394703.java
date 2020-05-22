private void loadWeather() {
    DateFormat df = DateFormat.getDateTimeInstance(
        DateFormat.SHORT, DateFormat.SHORT, Locale.getDefault());
    df.setTimeZone(TimeZone.getTimeZone("GMT+0400"));
    tv_time.setText(df.format(new Date()));
}