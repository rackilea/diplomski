// this is the difference between midnight October 15, 1582 UTC and midnight January 1, 1970 UTC as 100 nanosecond units
private static final long EPOCH_DIFFERENCE = 122192928000000000L;

private static final ZoneId GREENWICH_MEAN_TIME = ZoneId.of("GMT");

private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
        .appendText(DAY_OF_WEEK, FULL)
        .appendLiteral(", ")
        .appendText(MONTH_OF_YEAR, FULL)
        .appendLiteral(' ')
        .appendValue(DAY_OF_MONTH)
        .appendLiteral(", ")
        .appendValue(YEAR, 4)
        .appendLiteral(" at ")
        .appendValue(CLOCK_HOUR_OF_AMPM)
        .appendLiteral(':')
        .appendValue(MINUTE_OF_HOUR, 2)
        .appendLiteral(':')
        .appendValue(SECOND_OF_MINUTE, 2)
        .appendLiteral('.')
        .appendFraction(NANO_OF_SECOND, 7, 7, false)
        .appendLiteral(' ')
        .appendText(AMPM_OF_DAY)
        .appendLiteral(' ')
        .appendZoneText(FULL)
        .toFormatter(Locale.getDefault());

public static String formattedDateFromTimeBasedUuid(UUID uuid) {
    ZonedDateTime date = timeBasedUuidToDate(uuid);
    return FORMATTER.format(date);
}

public static ZonedDateTime timeBasedUuidToDate(UUID uuid) {
    if (uuid.version() != 1) {
        throw new IllegalArgumentException("Provided UUID was not time-based.");
    }
    // the UUID timestamp is in 100 nanosecond units.
    // convert that to nanoseconds
    long nanoseconds = (uuid.timestamp() - EPOCH_DIFFERENCE) * 100;
    long milliseconds = nanoseconds / 1000000000;
    long nanoAdjustment = nanoseconds % 1000000000;
    Instant instant = Instant.ofEpochSecond(milliseconds, nanoAdjustment);
    return ZonedDateTime.ofInstant(instant, GREENWICH_MEAN_TIME);
}