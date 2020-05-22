public Vector3f crossProduct(Vector3f vector1, Vector3f vector2) {
    Vector3f normalVector = new Vector3f();

    // Cross product. The normalVector contains the normal for the
    // surface, which is perpendicular both to vector1 and vector2.
    normalVector.x = vector1.y * vector2.z - vector1.z * vector2.y;
    normalVector.y = vector1.z * vector2.x - vector1.x * vector2.z;
    normalVector.z = vector1.x * vector2.y - vector1.y * vector2.x;

    return normalVector;
}