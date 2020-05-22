public class DateFormatter {
    private static final String ISO = "yyyyMMdd";
    private static final String EU_PATTERN = "yyyy-MM-dd";
    private static final String UK_PATTERN = "dd/MM/yyyy";
    private static final String US_PATTERN = "MM/dd/yyyy";
    private static final int EU = 1;
    private static final int UK = 2;
    private static final int US = 3;

    private static String formattedDate(int fmt, String isobasic) {
        String pattern = null;
        switch (fmt) {
            case EU: {
                pattern = EU_PATTERN;
                break;
            }
            case UK: {
                pattern = UK_PATTERN;
                break;
            }
            case US: {
                pattern = US_PATTERN;
                break;
            }
        }
        DateTimeFormatter parser = DateTimeFormatter.ofPattern(ISO);
        TemporalAccessor parsedDate = parser.parse(isobasic);
        return DateTimeFormatter.ofPattern(pattern).format(parsedDate);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(formattedDate(EU, "20180927"));
        System.out.println(formattedDate(UK, "20190131"));
        System.out.println(formattedDate(US, "20171225"));
    }
}