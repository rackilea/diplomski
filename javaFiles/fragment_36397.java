ZonedDateTime dateTime;
try {
    dateTime = ZonedDateTime.parse(dateTimeString, formatter);
} catch (DateTimeParseException dtpe) {
    dateTime = ZonedDateTime.parse(dateTimeString, 
                    formatter.withZone(ZoneId.of("Europe/Amsterdam")));
}