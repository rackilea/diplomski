ZoneId zone = ZoneId.of("America/Denver");
    DateTimeFormatter firstShotFormatter
            = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss'Z'xxx");

    String milliseconds = "1136239445000";

    Instant pointInTime = Instant.ofEpochMilli(Long.parseLong(milliseconds));
    String firstShot = pointInTime.atZone(zone).format(firstShotFormatter);
    // Offset should be negative
    if (firstShot.contains("Z-")) {
        // Remove minus sign from formatted offset
        String result = firstShot.replace("Z-", "Z");
        System.out.println("Formatted string: " + result);
    } else {
        throw new IllegalStateException(
                "Don’t know how to format a positive offset from UTC");
    }