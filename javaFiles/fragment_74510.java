PeriodFormatter pf = new PeriodFormatterBuilder()
    // hours
    .appendPrefix("Hours: ").appendHours()
    // optional space (if there are more fields)
    .appendSeparatorIfFieldsBefore(" ")
    // minutes
    .appendPrefix("Minutes: ").appendMinutes()
    // optional space (if there are more fields)
    .appendSeparatorIfFieldsBefore(" ")
    // seconds
    .appendPrefix("Seconds: ").appendSeconds()
    // create formatter
    .toFormatter();
System.out.println(pf.print(diff));