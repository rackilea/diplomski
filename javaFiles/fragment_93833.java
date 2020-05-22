String[] dateStrs = {
    "2018-11-02 11:39:03.4-04",
    "2018-11-02 11:45:22.71-04",
    "2018-11-03 14:59:17.503-04"
};

DateTimeFormatter f = new DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd HH:mm:ss.")
    .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, false)
    .appendPattern("X")
    .toFormatter();

// Single item:
LocalDateTime date = LocalDateTime.parse("2018-11-02 11:39:03.7356562-04", f);

// Multiple items:
List<LocalDateTime> dates = Arrays.asList(dateStrs).stream()
    .map(t -> LocalDateTime.parse(t, f))
    .collect(Collectors.toList());