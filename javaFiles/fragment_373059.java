public static long getUTCToMillis(String time) {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

    TimeZone timezone = TimeZone.getTimeZone("CET");

    try {
        Date date = sdf.parse(time);
        long offSet = timezone.getOffset(date.getTime());
        cal.setTime(date);
        cal.add(Calendar.MILLISECOND, offset);
        return cal.getTimeInMillis();
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return -1;
}