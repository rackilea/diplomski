DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    DateTimeFormatter timestampFormatter = DateTimeFormatter
            .ofPattern("dd/MM/yyyy hh:mm:ss.SSSSSS a XXX", Locale.ENGLISH);

    String dateString = "06/04/2019";
    String timestampString = "15/03/2018 03:46:59.000386 PM -05:00";
    OffsetDateTime timestampOnDate = OffsetDateTime
            .parse(timestampString, timestampFormatter)
            .with(LocalDate.parse(dateString, dateFormatter));
    System.out.println("Output:        " + timestampOnDate.format(timestampFormatter));
    System.out.println("Output in UTC: "
            + timestampOnDate.withOffsetSameInstant(ZoneOffset.UTC)
                    .format(timestampFormatter));