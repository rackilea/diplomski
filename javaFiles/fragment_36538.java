ZoneId zone = ZoneId.systemDefault();
    Instant beginofday = LocalDate.now(zone).atStartOfDay(zone).toInstant();

    long timestamp = beginofday.toEpochMilli();

    //adding points
    for buildings ... do
    Point point = Point.measurement("building").tag(tagsToAdd).fields(fieldsToAdd)
                        .time(timestamp, TimeUnit.MILLISECONDS).build();