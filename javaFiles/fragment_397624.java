public class A {
    private final int a;
    private final short b;
    private final double e;
    private final String g;

    public static class Aparam {
        private int a = 1;
        private short b = 2;
        private double e = 3.141593;
        private String g = "NONE";

        public Aparam a(int a) {
            this.a = a;
            return this;
        }

        public Aparam b(short b) {
            this.b = b;
            return this;
        }

        public Aparam e(double e) {
            this.e = e;
            return this;
        }

        public Aparam g(String g) {
            this.g = g;
            return this;
        }

        public A build() {
            return new A(this);
        }
    }

    public static Aparam a(int a) {
        return new Aparam().a(a);
    }

    public static Aparam b(short b) {
        return new Aparam().b(b);
    }

    public static Aparam e(double e) {
        return new Aparam().e(e);
    }

    public static Aparam g(String g) {
        return new Aparam().g(g);
    }

    public static A build() {
        return new Aparam().build();
    }

    private A(Aparam p) {
        this.a = p.a;
        this.b = p.b;
        this.e = p.e;
        this.g = p.g;
    }

    @Override public String toString() {
        return "{a=" + a + ",b=" + b + ",e=" + e + ",g=" + g + "}";
    }
}