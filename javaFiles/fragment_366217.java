public class Term {
    private int co, ex;

    public Term(int coeff, int exp) {
        co = coeff;
        ex = exp;
    }

    @Override
    public String toString() {
        return co + "x^" + ex;
    }
}