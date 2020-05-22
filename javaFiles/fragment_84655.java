public static DateFormat getFormat() {
    String systemLocale = System.getProperty("user.language"); //$NON-NLS-1$ 
    Locale locale = new Locale(systemLocale);
    DateFormat dateFormat = DateFormat.getDateTimeInstance(
        DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
    dateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
    return dateFormat;
}