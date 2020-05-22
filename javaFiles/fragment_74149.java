public static Date parseDate(String dateStr) throws IllegalArgumentException {
    // optionally change the separator
    dateStr = dateStr.replaceAll("\\D+", "/");

    for (String fmt : "dd/MM/yy,yyyy/MM/dd,dd/MM/yyyy".split(",")) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            sdf.setLenient(false);
            return sdf.parse(dateStr);
        } catch (ParseException ignored) {
        }
    }
    throw new IllegalArgumentException("Unable to parse date '" + dateStr + "'");
}

public static void main(String... args) {
    String dates = "1.2.12\n" +
            "01.02.2012\n" +
            "2012.02.01\n" +
            "01-01-12\n" +
            "1.1.2012";
    for (String dateStr : dates.split("\n")) {
        Object result;
        try {
            result = parseDate(dateStr);
        } catch (IllegalArgumentException e) {
            result = e;
        }
        System.out.println(dateStr + " => " + result);
    }
}