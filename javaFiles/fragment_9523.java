public class Matrix {
    public Matrix scale(int scaleFactor) {
        ... return Matrix ...
    }
}

public class Vector extends Matrix {
    ...

    @Override
    public Vector scale(int scaleFactor) { // <-- return sub type here!
        ... return Vector ...
    }
}