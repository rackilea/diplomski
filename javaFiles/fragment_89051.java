public static Locale[] possibleLocalesForDateString(String dateString) {
    Locale[] availableLocales = Locale.getAvailableLocales();
    return Arrays.stream(availableLocales)
            .filter(loc -> {
                for (FormatStyle style : FormatStyle.values()) {
                    DateTimeFormatter formatter 
                            = DateTimeFormatter.ofLocalizedDate(style).withLocale(loc);
                    try {
                        LocalDate.parse(dateString, formatter);
                        // succeeded; this is a possible locale
                        return true;
                    } catch (DateTimeParseException dtpe) {
                        // failed; ignore this locale/format style combination
                    }
                }
                return false;
            })
            .toArray(Locale[]::new);
}