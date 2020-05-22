public SimpleVector rotateAround(SimpleVector center, SimpleVector point, float angle) {
    SimpleVector newPos = new SimpleVector(point.x - center.x, 0, point.z - center.z);

    newPos.x = (float) (newPos.x * Math.cos(angle) - newPos.z * Math.sin(angle));
    newPos.z = (float) (newPos.x * Math.sin(angle) + newPos.z * Math.cos(angle));

    newPos.x += center.x;
    newPos.z += center.z;

    return newPos;
}