private static String[] formats = new String[] {/* Your list of possible formats */};
public static Date parse(String date) throws ParseException {
    for (String format : formats) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(date);
        } catch (ParseException e) {}
    }
    throw new ParseException(
            "This date does not conform to any known format", 0);
}