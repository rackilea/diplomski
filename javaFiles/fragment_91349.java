public ZonedDateTime getZdt(String myDate, String format) {
    try {
        return LocalDateTime.parse(myDate, DateTimeFormatter.ofPattern(format))
                .atZone(ZoneId.systemDefault());
    } catch (DateTimeParseException dtpe) {
        return LocalDate.parse(myDate, DateTimeFormatter.ofPattern(format))
                .atStartOfDay(ZoneId.systemDefault());
    }
}