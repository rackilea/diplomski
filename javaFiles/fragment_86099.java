private static final ChronoUnit[] chronoUnits = {ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS, ChronoUnit.HOURS, ChronoUnit.MINUTES, ChronoUnit.SECONDS};
private static final Map<ChronoUnit, Integer> chronoUnitPluralIdMap = new HashMap<ChronoUnit, Integer>() {{
    put(ChronoUnit.YEARS, R.plurals.chrono_unit_years_ago);
    put(ChronoUnit.MONTHS, R.plurals.chrono_unit_months_ago);
    put(ChronoUnit.DAYS, R.plurals.chrono_unit_days_ago);
    put(ChronoUnit.HOURS, R.plurals.chrono_unit_hours_ago);
    put(ChronoUnit.MINUTES, R.plurals.chrono_unit_minutes_ago);
    put(ChronoUnit.SECONDS, R.plurals.chrono_unit_seconds_ago);
}};

public static String getTimeStringUntilNowFromUTC(Context context, String utcDate) {
    Instant now = Instant.now(Clock.systemUTC());
    Instant then = Instant.parse(utcDate);
    for (ChronoUnit chronoUnit : chronoUnits) {
        if (then.isSupported(chronoUnit)) {
            long units = chronoUnit.between(then, now);
            if (units > 0) {
                //noinspection ConstantConditions
                return context.getResources().getQuantityString(chronoUnitPluralIdMap.get(chronoUnit), (int)units, (int)units);
            }
        }
    }
    return "-";
}

public static String getTimeBetweenTwoDates(Context context, String date1, String date2) {
    Instant date1Instant = Instant.parse(date1);
    Instant date2Instant = Instant.parse(date2);
    final long seconds = ChronoUnit.SECONDS.between(date1Instant, date2Instant);
    return getMinutesSecondsString(context, seconds);
}