final ZoneId est = ZoneId.of("America/New_York"); // ZoneId.systemDefault();
while (result.next()){
    ...
    Timestamp time = result.getTimestamp("start"); // utc is offset 0; no offset required
    ZonedDateTime zTime = time.toInstant().atZone(est);
    LocalDateTime start = zTime.toLocalDateTime();
    ...
}