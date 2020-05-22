private static int getMinuteOfDay(Date date) {
    Calendar cal = new GregorianCalendar();

    cal.setTime(date);

    return cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
}

private static void addAvailability(Date startTime, Date endTime, BitSet bs) {

    int startMinute = getMinuteOfDay(startTime);
    int endMinute = getMinuteOfDay(endTime);

    bs.set(startMinute, endMinute);
}

private static boolean timeIsAvailable(Date time, BitSet bs) {
    return bs.get(getMinuteOfDay(time));
}

static DateFormat TIME_FORMAT = new SimpleDateFormat("HH:MM:ss");

public static void main(String[] args) {
    BitSet availability = new BitSet();

    try {
        addAvailability(TIME_FORMAT.parse("02:00:00"), TIME_FORMAT.parse("04:00:00"), availability);
        addAvailability(TIME_FORMAT.parse("15:00:00"), TIME_FORMAT.parse("17:00:00"), availability);

        System.out.println(timeIsAvailable(TIME_FORMAT.parse("01:19:00"), availability));
        System.out.println(timeIsAvailable(TIME_FORMAT.parse("02:00:00"), availability));
        System.out.println(timeIsAvailable(TIME_FORMAT.parse("02:01:00"), availability));
        System.out.println(timeIsAvailable(TIME_FORMAT.parse("04:00:00"), availability));
        System.out.println(timeIsAvailable(TIME_FORMAT.parse("04:01:00"), availability));
        System.out.println(timeIsAvailable(TIME_FORMAT.parse("16:00:00"), availability));
        System.out.println(timeIsAvailable(TIME_FORMAT.parse("17:10:00"), availability));

    } catch (ParseException e) {
        throw new RuntimeException(e);
    }

}