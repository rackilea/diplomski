public class Matrix {
    protected void doScale(int scaleFactor) {
        ... original scale() code here...
    }

    public Matrix scale(int scaleFactor) {
        doScale(scaleFactor);
        return this;
    }
}

public class Vector extends Matrix {
    ...

    @Override

    public Vector scale(int scaleFactor) {
        doScale(scaleFactor);
        return this;
    }
}