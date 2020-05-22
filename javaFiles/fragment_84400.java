private static TemporalAccessor toJava8Time(Date date) {
    Instant instant = date.toInstant();

    if (instant.isBefore(Instant.ofEpochSecond(86400))) {
        return instant.atZone(ZoneId.systemDefault()).toLocalTime();
    } else if (instant.equals(instant.truncatedTo(ChronoUnit.HOURS))) {
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    } else {
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}