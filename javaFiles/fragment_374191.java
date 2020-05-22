public static class Bean {
    @FixedWidth(from = 2, to = 6)
    @Parsed
    int a1;

    @FixedWidth(from = 7, to = 11)
    @Parsed
    String a2;

    @FixedWidth(from = 14, to = 23)
    @Parsed
    String b1;

    @FixedWidth(from = 26, to = 40)
    @Parsed
    String c1;

    @FixedWidth(from = 41, to = 52)
    @Parsed
    String c2;

    @Override
    public String toString() {
        return "Bean{" +
                "a1=" + a1 +
                ", a2='" + a2 + '\'' +
                ", b1='" + b1 + '\'' +
                ", c1='" + c1 + '\'' +
                ", c2='" + c2 + '\'' +
                '}';
    }
}