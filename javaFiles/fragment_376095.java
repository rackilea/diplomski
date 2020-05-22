class Test {
    public static final String s1 = str(" ... long string ... ");
    public static final String s2 = str(" ... long string ... ");
    public static final String s3 = str(" ... long string ... ");

    public static final List<String> strings = new ArrayList<>();

    public static String str(String s) {
        strings.add(s);
        return s;
    }
}