// v1, v2 and v3 are the vertices of the triangle, in no specific order
// The Y coordinates are ignored (two dimensional)
public static boolean isLocationInTriangle(Location location, Location v1, Location v2, Location v3) {
    // Bunch of math...
    double a = 0.5 * (-v2.getZ() * v3.getX() + v1.getZ() * (-v2.getX() + v3.getX()) + v1.getX() * (v2.getZ() - v3.getZ()) + v2.getX() * v3.getZ());
    int sign = a < 0 ? -1 : 1;
    double s = (v1.getZ() * v3.getX() - v1.getX() * v3.getZ() + (v3.getZ() - v1.getZ()) * location.getX() + (v1.getX() - v3.getX()) * location.getZ()) * sign;
    double t = (v1.getX() * v2.getZ() - v1.getZ() * v2.getX() + (v1.getZ() - v2.getZ()) * location.getX() + (v2.getX() - v1.getX()) * location.getZ()) * sign;

    return s > 0 && t > 0 && (s + t) < 2 * a * sign;
}