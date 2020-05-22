private String getDate(long time) {
    Calendar cal = Calendar.getInstance(Locale.ENGLISH);
    cal.setTimeInMillis(time);
    String date = DateFormat.format("yyyy-MM-dd", cal).toString();
    return date;
}