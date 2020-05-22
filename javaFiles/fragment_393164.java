final class StringToDateTime implements Converter<String, DateTime> {
    private static final DateTimeFormatter FORMAT = // init here

    public DateTime convert(String source) {
        return FORMAT.parseDateTime(source);
    }

}