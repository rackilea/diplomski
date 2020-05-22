ZoneId zone = ZoneId.of("Asia/Kolkata");
    String timeString = "18:25:30.245635";
    LocalTime time = LocalTime.parse(timeString);
    LocalTime utcTime = LocalDate.now(zone)        // Today
            .atTime(time)                          // Today at the time in question
            .atZone(zone)                          // Date and time in IST
            .toOffsetDateTime()                    // Convert to OffsetDateTime for the next step
            .withOffsetSameInstant(ZoneOffset.UTC) // Convert to UTC
            .toLocalTime();                        // Extract only the time of day
    System.out.println("UTC time: " + utcTime);