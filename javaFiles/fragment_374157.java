DateTimeFormatter formatter 
            = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);
    LocalDateTime dateTime;
    try {
        dateTime = LocalDateTime.parse(date_s, formatter);
        System.out.println(dateTime);
    } catch (DateTimeParseException e) {
        System.err.println(e);
    }