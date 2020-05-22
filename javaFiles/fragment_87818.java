public abstract class Expr {
    // So that you can't add more subclasses outside this block
    private Expr() {}

    // Simulate pattern matching:
    // (This CAN be done with instanceof, but that's ugly and not OO)
    public boolean isLit() {
        return false;
    }
    public boolean isAdd() {
        return false;
    }
    public Lit asLit() {
        throw new UnsupportedOperationException("This is not a Lit");
    }
    public Add asAdd() {
        throw new UnsupportedOperationException("This is not an Add");
    }

    public static class Lit extends Expr {
        public final int n;
        public Lit(int n) {
            this.n = n;
        }
        @Override
        public boolean isLit() {
            return true;
        }
        @Override
        public Lit asLit() {
            return this;
        }
    }

    public static class Add extends Expr {
        public final Expr a, b;
        public Lit(Expr a, Expr b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public boolean isAdd() {
            return true;
        }
        @Override
        public Add asAdd() {
            return this;
        }
    }
}