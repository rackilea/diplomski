ZoneId zone = ZoneId.of("America/Chicago");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a (OOOO)", Locale.US);

    LocalDate startDate = LocalDate.of(2019, Month.SEPTEMBER, 18);
    LocalTime startTime = LocalTime.of(14, 0);
    LocalTime endTime = LocalTime.of(4, 0);

    ZonedDateTime start = ZonedDateTime.of(startDate, startTime, zone);
    ZonedDateTime end = ZonedDateTime.of(startDate, endTime, zone);
    if (end.isBefore(start)) {
        end = ZonedDateTime.of(startDate.plusDays(1), endTime, zone);
    }

    System.out.println("Date: " + startDate);
    System.out.println("Start Time: " + start.format(timeFormatter));
    System.out.println("End Time: " + end.format(timeFormatter));
    System.out.println("Ends on " + end.toLocalDate());