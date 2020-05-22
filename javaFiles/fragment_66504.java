/**
 * Adds the location by another. Not world-aware.
 *
 * @see Vector
 * @param x X coordinate
 * @param y Y coordinate
 * @param z Z coordinate
 * @return the same location
 */
public Location add(double x, double y, double z) {
    this.x += x;
    this.y += y;
    this.z += z;
    return this;
}