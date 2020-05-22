public class GInt {

    private int real;
    private int imag;

    public GInt(int r) {
        imag=0;
        real=r;
    }

    public GInt(int r, int i) {
        real = r;
        imag = i;
    }

    GInt add(GInt rhs) {
        GInt added;
        int nReal = this.real + rhs.real;
        int nImag = this.imag + rhs.real;

        added = new GInt(nReal, nImag);

        return added;
    }
}