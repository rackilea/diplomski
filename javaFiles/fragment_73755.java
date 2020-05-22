DateTime dateTime = new DateTime();
DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd")
            .appendTimeZoneOffset("Z", false, 2, 2)
            .toFormatter();
System.out.println(formatter.print(dateTime.withZone(DateTimeZone
            .forID("Zulu"))));