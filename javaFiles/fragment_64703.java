DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");

    String arrivalTime = "1720";
    String departingTime = "1100";
    String arrivalDate = "20200220";
    String departingDate = "20200211";
    String arrivalTimeZone = "Africa/Niamey";
    String departingTimeZone = "America/Mendoza";

    ZonedDateTime departure = LocalDate.parse(departingDate, DateTimeFormatter.BASIC_ISO_DATE)
            .atTime(LocalTime.parse(departingTime, timeFormatter))
            .atZone(ZoneId.of(departingTimeZone));
    ZonedDateTime arrival = LocalDate.parse(arrivalDate, DateTimeFormatter.BASIC_ISO_DATE)
            .atTime(LocalTime.parse(arrivalTime, timeFormatter))
            .atZone(ZoneId.of(arrivalTimeZone));

    Duration difference = Duration.between(departure, arrival);
    System.out.println(difference);