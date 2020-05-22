// London timezone
ZoneId londonTimezone = ZoneId.of("Europe/London");

// the historical local date/time I want to check (March 16th 1975, 3 AM)
LocalDateTime localDt = LocalDateTime.of(1975, 3, 16, 3, 0, 0);

// convert to UK timezone (1975-03-16T03:00+01:00)
ZonedDateTime londonDt = localDt.atZone(londonTimezone);

// convert to UTC (1975-03-16T02:00:00Z)
Instant instant = londonDt.toInstant();