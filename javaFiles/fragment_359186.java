private static final class QuadraticEq {
    private static final Pattern EQN = Pattern.compile("([+-]?\\d+)[Xx]2\\s*([+-]?\\d+)[Xx]\\s*([+-]?\\d+)\\s*=\\s*0");
    private final int a;
    private final int b;
    private final int c;

    private QuadraticEq(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static QuadraticEq parseString(final String eq) {
        final Matcher matcher = EQN.matcher(eq);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Not a valid pattern " + eq);
        }
        final int a = Integer.parseInt(matcher.group(1));
        final int b = Integer.parseInt(matcher.group(2));
        final int c = Integer.parseInt(matcher.group(3));
        return new QuadraticEq(a, b, c);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuadraticEq{");
        sb.append("a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append('}');
        return sb.toString();
    }
}