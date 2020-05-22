DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .appendPattern("yy-")
    .parseCaseInsensitive()
    .parseLenient()
    .appendPattern("MMM")
    .parseStrict()
    .parseCaseSensitive()
    .appendPattern("-dd")
    .toFormatter(Locale.US);