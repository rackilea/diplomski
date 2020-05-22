public static void main(String... args) {
    MyParser parser = new MyParser();
    IntStream.range(0, 100).parallel().forEach(i-> parser.parseTl("20170816"));
    IntStream.range(0, 100).parallel().forEach(i-> parser.parse("20170816"));
}

static class MyParser {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private static final ThreadLocal<SimpleDateFormat> sdftl =
            ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyyMMdd"));

    public Date parse(String str) {
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Date parseTl(String str) {
        try {
            return sdftl.get().parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}