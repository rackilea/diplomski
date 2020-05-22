public static boolean intersectsWith(BoundingBox boundingBox, Sphere sphere) {
    float dmin = 0;

    Vector3 center = sphere.center;
    Vector3 bmin = boundingBox.getMin();
    Vector3 bmax = boundingBox.getMax();

    if (center.x < bmin.x) {
        dmin += Math.pow(center.x - bmin.x, 2);
    } else if (center.x > bmax.x) {
        dmin += Math.pow(center.x - bmax.x, 2);
    }

    if (center.y < bmin.y) {
        dmin += Math.pow(center.y - bmin.y, 2);
    } else if (center.y > bmax.y) {
        dmin += Math.pow(center.y - bmax.y, 2);
    }

    if (center.z < bmin.z) {
        dmin += Math.pow(center.z - bmin.z, 2);
    } else if (center.z > bmax.z) {
        dmin += Math.pow(center.z - bmax.z, 2);
    }

    return dmin <= Math.pow(sphere.radius, 2);
}