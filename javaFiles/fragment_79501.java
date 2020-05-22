private String getDate(long time) {
    Calendar cal = Calendar.getInstance(Locale.ENGLISH);
    cal.setTimeInMillis(time);
    String date = DateFormat.format("dd-MM-yyyy", cal).toString();
    return date;
}