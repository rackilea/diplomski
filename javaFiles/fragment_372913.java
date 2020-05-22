DateTimeFormatter globalFormat = new DateTimeFormatterBuilder()
            .appendPattern("yyyyMMddHHmmss")
            .appendValue(ChronoField.MILLI_OF_SECOND, 3)
            .toFormatter();
    String input = "2019082905020425";
    String adaptedInput = input + "0";
    LocalDateTime currentDateTime = LocalDateTime.parse(adaptedInput, globalFormat);
    System.out.println("Parsed date and time: " + currentDateTime);