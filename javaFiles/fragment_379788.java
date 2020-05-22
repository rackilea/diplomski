public abstract class Doubler {
    int a;

    public Doubler(int a) {
        this.a = a;
    }

    abstract int modifyResult(int aResult);

    int calculate() {
        int rv = a * 2;
        return modifyResult(rv);
    }
}

public class DoublerAndAdder extends Doubler {
    int b;

    public DoublerAndAdder(int a, int b) {
        super(a);
        this.b = b;
    }

    @Override
    public int modifyResult(int aResult) {
        return aResult + b;
    }
}