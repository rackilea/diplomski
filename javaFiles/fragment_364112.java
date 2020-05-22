public static void main(String[] args) {
    TimeZone utc = TimeZone.getTimeZone("UTC");
    Calendar date = Calendar.getInstance(utc);
    DateFormat format = DateFormat.getDateTimeInstance();
    format.setTimeZone(utc);
    date.set(2012, 02, 24, 23, 00, 00);
    for (int i = 0; i < 10; i++) {
        System.out.println(format.format(date.getTime()));
        date.add(Calendar.HOUR_OF_DAY, 1);
    }
}