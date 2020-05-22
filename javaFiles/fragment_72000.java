public ThreeVector unitv() {
    double magnitude = magnitude();
    if (magnitude != 0) {
        return new ThreeVector(x/magnitude, y/magnitude, z/magnitude);
    }
    return new ThreeVector(0, 0, 0);
}