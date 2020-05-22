DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // date and time, use built-in
    .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    // append offset
    .appendPattern("xxx")
    // create formatter
    .toFormatter();