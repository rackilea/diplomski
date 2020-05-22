public class Thing {

    private DoubleFunction<Float> func;

    public Thing(DoubleFunction<Float> func) {
        this.func = func;
    }

    public float F(float x) {
        return func.apply(x);
    }
}