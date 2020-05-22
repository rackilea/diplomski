DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // date and time, use built-in
    .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    // append offset, set "-00:00" when offset is zero
    .appendOffset("+HH:MM", "-00:00")
    // create formatter
    .toFormatter();

System.out.println(dateTime.format(fmt));