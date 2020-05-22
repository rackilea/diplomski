public abstract class Doubler {
    int a;

    public Doubler(int a) {
        this.a = a;
    }

    public int modifyResult(int aResult) {
        return aResult;
    }

    int calculate() {
        int rv = a * 2;
        return modifyResult(rv);
    }
}