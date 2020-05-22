DateTimeFormatter parser = new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        .optionalStart()
        .appendOffsetId()
        .optionalEnd()
        .toFormatter();

    TemporalAccessor accessor = parser.parse(isoDateTime);
    if (accessor.isSupported(ChronoField.OFFSET_SECONDS)) {
        var zoned = ZonedDateTime.from(accessor);
        return zoned.withZoneSameInstant(ZoneId.of(timezone)).toLocalDateTime();
    }
    return LocalDateTime.from(accessor);