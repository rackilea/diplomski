ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
        .append(ISO_LOCAL_DATE_TIME) // use the existing formatter for date time
        .appendOffset("+HH:MM", "+00:00") // set 'noOffsetText' to desired '+00:00'
        .toFormatter();

System.out.println(now.format(dateTimeFormatter)); // 2019-12-20T17:58:06.847274+00:00