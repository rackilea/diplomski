ZonedDateTime startTimestamp = ZonedDateTime.of(LocalDateTime.of(2018, 1, 1, 0, 0), ZoneId.of("CET"));
ZonedDateTime endTimestamp = startTimestamp.plusMonths(5);

Period period = Period.parse("P1M");
while (startTimestamp.isBefore(endTimestamp)) {
    System.out.println(startTimestamp);
    startTimestamp = startTimestamp.plus(period);
}