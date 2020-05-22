System.out.println( "dateStart: " + dateStart ); // BEWARE: j.u.Date objects are in UTC by definition, but "toString" method applies the JVM's current default time zone. Misleading!
System.out.println( "dateStop: " + dateStop );
System.out.println( "dateTarget: " + dateTarget );

System.out.println( "start: " + start );
System.out.println( "stop: " + stop );
System.out.println( "target: " + target );

System.out.println( "interval: " + interval );
System.out.println( "period: " + period );
System.out.println( "duration: " + duration );

System.out.println( "laterByPeriod: " + laterByPeriod );  // Notice the change in offset because of DST (Daylight Saving Time) in Québec.
System.out.println( "laterByDuration: " + laterByDuration );