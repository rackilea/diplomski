public static void main(String[] args) throws Exception {
    String str = "120100";

    DateTimeParser[] formats = {
            DateTimeFormat.forPattern("MM/dd/yyyy").getParser(),
            DateTimeFormat.forPattern("MM/dd/yy").getParser(),
            DateTimeFormat.forPattern("MM-dd-yyyy").getParser(),
            DateTimeFormat.forPattern("MM-dd-yy").getParser(),
            DateTimeFormat.forPattern("MMddyy").getParser()
    };

    DateTimeFormatter formatter = new DateTimeFormatterBuilder().append(null, formats).toFormatter()
            .withPivotYear(1950).withLocale(Locale.US);

    DateTime dateTime = formatter.parseDateTime(str);
    System.out.println(dateTime);       
}