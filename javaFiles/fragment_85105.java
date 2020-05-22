// create today's date in UTC
DateTime mStartDate = DateTime.now(DateTimeZone.UTC).withTimeAtStartOfDay();
// date/time in UTC
System.out.println(mStartDate); // 2017-06-13T00:00:00.000Z
// date/time in my default timezone (America/Sao_Paulo)
System.out.println(mStartDate.withZone(DateTimeZone.getDefault())); // 2017-06-12T21:00:00.000-03:00