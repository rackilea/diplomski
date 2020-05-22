/**
 * A geometric shape interface. You can do two things with it.
 * 1. Ask it to describe itself (to stdout);
 * 2. Ask it to return a bigger version of itself (double the size).
 */
public interface GeometricShape<T extends GeometricShape<T>> {
    /**
     * Print a description to STDOUT
     */
    void describe();

    /**
     * Returns a bigger shape.
     * @return Something that's a GeometricShape
     */
    T supersize();
}