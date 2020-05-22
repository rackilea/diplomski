Map<Long, String> map = ImmutableMap.of(0L, "Z", 3600L, "A", 7200L, "B");
DateTimeFormatter f = new DateTimeFormatterBuilder()
    .appendPattern("HH:mm")
    .appendText(ChronoField.OFFSET_SECONDS, map)
    .toFormatter();
System.out.println(OffsetTime.now().format(f));
System.out.println(OffsetTime.parse("11:30A", f));