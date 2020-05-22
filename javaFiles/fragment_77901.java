// Simulate inputs, a trio of java.util.Date objects.
java.util.Date dateStart = new DateTime( 2014 , 1 , 2 , 0 , 0 , 0 , DateTimeZone.UTC ).toDate();
java.util.Date dateStop = new DateTime( 2014 , 3 , 2 , 0 , 0 , 0 , DateTimeZone.UTC ).toDate();
java.util.Date dateTarget = new DateTime( 2014 , 7 , 1 , 0 , 0 , 0 , DateTimeZone.UTC ).toDate();

// Convert inputs to Joda-Time
DateTimeZone timeZone = DateTimeZone.forID( "America/Montreal" ); // Or DateTimeZone.UTC.
DateTime start = new DateTime( dateStart , timeZone );
DateTime stop = new DateTime( dateStop , timeZone );
DateTime target = new DateTime( dateTarget , timeZone );

// Determine elapsed time in three fashions: (a) pair of points on timeline, (b) An amount of weeks, days, hours, and such, and (c) actual milliseconds.
Interval interval = new Interval( start , stop );
Period period = interval.toPeriod();
Duration duration = interval.toDuration();

// Add elapsed time to target date-time. Show results of adding either period or duration.
DateTime laterByPeriod = target.plus( period );
DateTime laterByDuration = target.plus( duration );