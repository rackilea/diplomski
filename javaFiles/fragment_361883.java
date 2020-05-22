boolean hasAmPmClock(Locale locale) {
        DateFormat stdFormat = DateFormat.getTimeInstance(DateFormat.SHORT,
                Locale.US);
        DateFormat localeFormat = DateFormat.getTimeInstance(DateFormat.LONG,
                locale);
        String midnight = "";
        try {
            midnight = localeFormat.format(stdFormat.parse("12:00 AM"));
        } catch (ParseException ignore) {
        }
        return midnight.contains("12");
}