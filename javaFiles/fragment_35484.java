private static Calendar createCalendar(TimeZone zone,
                                       Locale aLocale) {
    Calendar cal = null;

    String caltype = aLocale.getUnicodeLocaleType("ca");
    if (caltype == null) {
        // Calendar type is not specified.
        // If the specified locale is a Thai locale,
        // returns a BuddhistCalendar instance.
        if ("th".equals(aLocale.getLanguage())
                && ("TH".equals(aLocale.getCountry()))) {
            cal = new BuddhistCalendar(zone, aLocale);
        } else {
            cal = new GregorianCalendar(zone, aLocale);
        }
    } else if (caltype.equals("japanese")) {
        cal = new JapaneseImperialCalendar(zone, aLocale);
    } else if (caltype.equals("buddhist")) {
        cal = new BuddhistCalendar(zone, aLocale);
    } else {
        // Unsupported calendar type.
        // Use Gregorian calendar as a fallback.
        cal = new GregorianCalendar(zone, aLocale);
    }

    return cal;
}