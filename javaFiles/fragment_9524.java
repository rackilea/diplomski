public class Vector extends Matrix {
    ...

    @Override
    public Vector scale(int scaleFactor) { // <-- return sub type here!
        return (Vector) super.scale(scaleFactor);
    }
}