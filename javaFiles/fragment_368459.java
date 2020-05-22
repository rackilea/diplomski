public PointsHolder read(Json json, JsonValue jsonData, Class type) {
    PointsHolder pointsHolder = new PointsHolder();
    for (JsonValue child = jsonData.child; child != null; child = child.next.next) {
        Vector2 vector2 = new Vector2();
        vector2.x = child.asFloat();
        vector2.y = child.next.asFloat();
        pointsHolder.splinePoints.add(vector2);
    }

    return pointsHolder;
}