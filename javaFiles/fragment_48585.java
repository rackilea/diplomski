DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
Map<Long, String> mapToRoman = new HashMap<>();
mapToRoman.put(1L, "1st");
mapToRoman.put(2L, "2nd");
mapToRoman.put(3L, "3rd");
mapToRoman.put(4L, "4th");
// continue to map all available days in a month
builder.appendText(ChronoField.DAY_OF_MONTH, mapToRoman );
builder.append(DateTimeFormatter.ofPattern(" MM yyyy", Locale.US));
DateTimeFormatter formatter = builder.toFormatter();