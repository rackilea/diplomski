public static float pickRandomPointBetween(float corner1, float corner2) {
    if (corner1 == corner2) {
        return corner1;
    }
    float delta = corner2 - corner1;
    float offset = rand.nextFloat() * delta;
    return corner1 + offset;
}