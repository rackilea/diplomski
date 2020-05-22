public static LocalDateTime parse(String text, List<DateTimeFormatter> formats) {
    LocalDateTime ldt = null;
    for (DateTimeFormatter formatter : formats) {
        try {
            ldt = LocalDateTime.parse(text, formatter);
        } catch (DateTimeParseException e) {
            // Maybe log the failure if you're interested
        }
    }
    return ldt;
}