public boolean isInTwoVectors(Vector3 pos1, Vector3 pos2, Vector3 check) {
    int minX = Math.min(pos1.x, pos2.x);
    int maxX = Math.max(pos1.x, pos2.x);
    int minY = Math.min(pos1.y, pos2.y);
    int maxY = Math.max(pos1.y, pos2.y);
    int minZ = Math.min(pos1.z, pos2.z);
    int maxZ = Math.max(pos1.z, pos2.z);
    return check.x >= minX && check.x <= maxX && check.y >= minY && check.y <= maxY
        && check.z >= minZ && check.z <= maxZ;
}