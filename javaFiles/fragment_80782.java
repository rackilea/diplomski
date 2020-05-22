DateTimeFormatter searchDateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    ZoneId clientZone = ZoneId.of("Asia/Colombo");
    String startDate = "29/01/2018";
    String endDate = "04/02/2018";

    Instant searchStartTime = LocalDate.parse(startDate, searchDateFormatter)
            .atStartOfDay(clientZone)
            .toInstant();
    Instant searchEndTime = LocalDate.parse(endDate, searchDateFormatter)
            .plusDays(1)
            .atStartOfDay(clientZone)
            .toInstant();

    System.out.println("" + searchStartTime + " inclusive to " 
                        + searchEndTime + " exclusive");