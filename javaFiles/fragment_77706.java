public static long getMillSecond(DayOfWeek day){
    ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Europe/Paris"));//Or any zone time
    ZonedDateTime nextSaturday = now
            .with(TemporalAdjusters.next(day))
            .with(LocalTime.of(20, 0));
    return ChronoUnit.MILLIS.between(now, nextSaturday);
}