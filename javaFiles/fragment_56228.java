public static void main(String[] args) {
    TimeZone tz = TimeZone.getTimeZone("UTC");
    Calendar cal = Calendar.getInstance(tz);
    cal.setTimeInMillis(0);
    DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");
    sdf.setTimeZone(tz);
    System.out.println(sdf.format(cal.getTime()));
}