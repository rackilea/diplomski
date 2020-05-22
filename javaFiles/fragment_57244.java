LocalDate.of(2016, 5, 10)

    // e.g. LocalTime.of(12, 0) or .atStartOfDay()
    // - *not* midnight, in general, since this does not always exist.
    .atTime(someLocalTime)

    // e.g. ZoneId.of("UTC")
    .atZone(someTimeZoneId)

    .toEpochSecond();