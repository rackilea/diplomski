String dateInMillis = "1413225446.92000";
    String[] secondsAndFraction = dateInMillis.split("\\.");
    int nanos = 0;
    if (secondsAndFraction.length > 1) { // there’s a fractional part
        // extend fractional part to 9 digits to obtain nanoseconds
        String nanosecondsString
                = (secondsAndFraction[1] + "000000000").substring(0, 9);
        nanos = Integer.parseInt(nanosecondsString);
        // if the double number was negative, the nanos must be too
        if (dateInMillis.startsWith("-")) {
            nanos = -nanos;
        } 
    }
    ZonedDateTime zdt = Instant
            .ofEpochSecond(Long.parseLong(secondsAndFraction[0]), nanos)
            .atZone(ZoneId.of("Asia/Manila"));
    System.out.println(zdt);