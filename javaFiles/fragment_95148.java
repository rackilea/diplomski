// London timezone
ZoneId londonTimezone = ZoneId.of("Europe/London");

// October 26th 1975, 2 AM - the ambiguous local time in London, due to DST end
LocalDateTime localDt = LocalDateTime.of(1975, 10, 26, 2, 0, 0);
// convert to UK timezone (default is the local time in DST: 1975-10-26T02:00+01:00)
ZonedDateTime londonDt = localDt.atZone(londonTimezone);

// get the date in DST (1975-10-26T02:00+01:00)
System.out.println(londonDt.withEarlierOffsetAtOverlap());
// get the date after DST ends (1975-10-26T02:00Z)
System.out.println(londonDt.withLaterOffsetAtOverlap());