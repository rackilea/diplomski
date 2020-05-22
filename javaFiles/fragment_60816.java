List<String> timezones = // timezones you want

// month that I care about (example: March 2018)
YearMonth yearMonth = YearMonth.of(2018, 3);
for (String zoneName : timezones) {
    ZoneId zone = ZoneId.of(zoneName);
    // get midnight at first day of month, in this timezone
    ZonedDateTime utc = yearMonth
        // 1st of month
        .atDay(1)
        // midnight at the timezone
        .atStartOfDay(zone)
        // convert to UTC
        .withZoneSameInstant(ZoneOffset.UTC);

    // get the fields you need to configure the job
    utc.getDayOfMonth();
    utc.getHour();
    ... etc
}