public class Intersections {

    /**
     * Returns a list of intersection points between the edge of a circle and a line.
     * @param cx Circle center X coordinate.
     * @param cy Circle center Y coordinate.
     * @param r Circle radius.
     * @param x1 First line X coordinate.
     * @param y1 First line Y coordinate.
     * @param x2 Second line X coordinate.
     * @param y2 Second line Y coordinate.
     * @return A list of intersection points.
     */
    public static List<Vector2> getCircleLineIntersectionPoints(
            float cx, float cy, float r, float x1, float y1, float x2, float y2) {
        // Find values to use in quadratic formula
        float dx = x2 - x1;
        float dy = y2 - y1;
        float a = dx * dx + dy * dy;
        float b = 2 * dx * (x1 - cx) + 2 * dy * (y1 - cy);
        float c = (float) Math.pow((x1 - cx), 2) + (float) Math.pow((y1 - cy), 2) - r * r;
        float d = b * b - 4 * a * c;  // Discriminant

        ArrayList<Vector2> points = new ArrayList<>();
        if (d >= 0) {
            // Perform quadratic formula to get 2 points
            float root = (float) Math.sqrt(d);
            float t1 = 2 * c / (-b + root);
            float t2 = 2 * c / (-b - root);

            // Need the rectangle bounds that the line fits in to check
            // if intersection points are within the line bounds
            float xmin = Math.min(x1, x2);
            float ymin = Math.min(y1, y2);
            float xmax = Math.max(x1, x2);
            float ymax = Math.max(y1, y2);

            // Add first point
            float p1x = x1 + dx * t1;
            float p1y = y1 + dy * t1;
            if (isPointInRectangle(xmin, ymin, xmax, ymax, p1x, p1y)) {
                points.add(new Vector2(p1x, p1y));
            }

            // Add second point if there's one
            if (!MathUtils.isEqual(t1, t2)) {
                float p2x = x1 + dx * t2;
                float p2y = y1 + dy * t2;
                if (isPointInRectangle(xmin, ymin, xmax, ymax, p2x, p2y)) {
                    points.add(new Vector2(p2x, p2y));
                }
            }
        }
        return points;
    }

    private static boolean isPointInRectangle(
            float xmin, float ymin, float xmax, float ymax, float px, float py) {
        return px >= xmin && py >= ymin && px <= xmax && py <= ymax;
    }
}