String dateString = "19801115";
    String timeString = "1530";

    DateTimeFormatter dtf = new DateTimeFormatterBuilder()
            .appendPattern("yyyyMMddHHmm")
            .toFormatter()
            .withZone(ZoneId.systemDefault() /*<- needed time zone here*/);
    ZonedDateTime zdtOriginal = ZonedDateTime.parse(dateString + timeString, dtf);

    System.out.println(zdtOriginal.toInstant()/*returns an Instant*/);

    // this way you adjust an Instant to a time zone you need
    ZonedDateTime zdt = zdtOriginal.withZoneSameLocal(ZoneId.of("GMT") /*<- needed time zone here*/);
    System.out.println(zdt.toInstant()/*returns an Instant*/);