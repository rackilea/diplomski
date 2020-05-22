public class DateTimeTest {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        GregorianCalendar date = (GregorianCalendar) GregorianCalendar.getInstance(TimeZone
            .getTimeZone("CET"));

        // 26.10.2014 01:00:00
        date.set(2014, 9, 26, 1, 0, 0);

        // 25 Oct 2014 23:00:00 GMT 1414278000764
        System.out.println("CET to UTC    : " + date.getTime().toGMTString() + " "
            + date.getTimeInMillis());

        date.setTimeZone(TimeZone.getTimeZone("UTC"));

//      date.roll(Calendar.HOUR_OF_DAY, true);  //uncomment this line & comment below line & check the different behavior of Calender.
        date.get(Calendar.HOUR_OF_DAY);

        // 25 Oct 2014 23:00:00 GMT 1414278000764
        System.out.println("UTC          : " + date.getTime().toGMTString() + " "
            + date.getTimeInMillis());

        date.set(Calendar.HOUR_OF_DAY, 0);

        // 25 Oct 2014 00:00:00 GMT 1414195200218
        System.out.println("UTC Midnight : " + date.getTime().toGMTString() + " "
            + date.getTimeInMillis());
    }
}