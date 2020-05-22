public abstract class Vector<T extends Vector<T>> {

    protected float[] coordinates;

    protected Vector(float[] coordinates, int length) {
        this.coordinates = Arrays.copyOf(coordinates, length);
    }

    public float int dotproduct(T vector) {
        // do something
    }
}