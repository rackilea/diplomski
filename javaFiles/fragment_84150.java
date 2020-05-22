public class Addition extends Operation {
    @Override
    public float getResult(float a, float b) {
        return a + b;
    }
}
public class Division extends Operation {
    @Override
    public float getResult(float a, float b) {
        return a / b;
    }
}