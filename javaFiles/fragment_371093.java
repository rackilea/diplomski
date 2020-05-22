LocalTime time1 = format.parseLocalTime(s1);
LocalTime time2 = format.parseLocalTime(s2);
Period period;

if (time1.isBefore(time2)) {
    period = new Period(time1, time2);
} else {
    DateTime dateTime1 = time1.toDateTimeToday();
    DateTime dateTime2 = time2.toDateTimeToday().plusDays(1);
    period = new Period(dateTime1, dateTime2);
}
...
String sum = periodFormatter.print(period);