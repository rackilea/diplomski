public abstract class SimpleDateTimePrinter implements DateTimePrinter {

    protected abstract String getText(ReadablePartial partial, Locale locale);

    @Override
    public void printTo(StringBuffer buf, long instant, Chronology chrono,
            int displayOffset, DateTimeZone displayZone, Locale locale) {
        DateTime dateTime = new DateTime(instant, chrono.withZone(displayZone));
        String text = getText(dateTime.toLocalDateTime(), locale);
        buf.append(text);
    }

    @Override
    public void printTo(Writer out, long instant, Chronology chrono,
            int displayOffset, DateTimeZone displayZone, Locale locale)
            throws IOException {
        DateTime dateTime = new DateTime(instant, chrono.withZone(displayZone));
        String text = getText(dateTime.toLocalDateTime(), locale);
        out.write(text);
    }

    @Override
    public void printTo(StringBuffer buf, ReadablePartial partial, Locale locale) {
        buf.append(getText(partial, locale));
    }

    @Override
    public void printTo(Writer out, ReadablePartial partial, Locale locale)
            throws IOException {
        out.write(getText(partial, locale));
    }
}