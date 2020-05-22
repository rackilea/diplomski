public static boolean possiblyInside(List<Double> arrayX, List<Double> arrayY, double locationX, double locationY, double locationAccuracy) {
    if (arrayX.size() != arrayY.size()) {
        throw new IllegalArgumentException("Array length not equal");
    }

    if (arrayX.size() < 3) {
        return false;
    }

    double minimumDistance = Double.MAX_VALUE;
    for (int i = 0; i < arrayX.size(); i++) {
        double p1x = i == 0 ? arrayX.get(arrayX.size() - 1) : arrayX.get(i - 1);
        double p1y = i == 0 ? arrayY.get(arrayY.size() - 1) : arrayY.get(i - 1);
        double p2x = arrayX.get(i);
        double p2y = arrayY.get(i);

        Coordinate closest = getClosestPointOnLine(p1x, p1y, p2x, p2y, locationX, locationY);
        double currentDistance = distanceMeterBetweenPoints(closest.latitude, closest.longitude, locationX, locationY);
        if (currentDistance < minimumDistance) {
            minimumDistance = currentDistance;
        }
    }

    return (minimumDistance <= locationAccuracy);
}

private static Coordinate getClosestPointOnLine(double sx1, double sy1, double sx2, double sy2, double px, double py) {
    double xDelta = sx2 - sx1;
    double yDelta = sy2 - sy1;

    if ((xDelta == 0) && (yDelta == 0)) {
        throw new IllegalArgumentException("Line start equals line end");
    }

    double u = ((px - sx1) * xDelta + (py - sy1) * yDelta) / (xDelta * xDelta + yDelta * yDelta);

    final Coordinate closestPoint;
    if (u < 0.0) {
        closestPoint = new Coordinate(sx1, sy1);
    } else if (u > 1.0) {
        closestPoint = new Coordinate(sx2, sy2);
    } else  {
        closestPoint = new Coordinate((int) Math.round(sx1 + u * xDelta), (int) Math.round(sy1 + u * yDelta));
    }

    return closestPoint;
}

public static double distanceMeterBetweenPoints(double aX, double aY, double bX, double bY) {
    double rad = Math.PI / 180;
    int r = 6371;

    double dLat = (aX - bX) * rad;
    double dLng = (aY - bY) * rad;

    double x = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(aX * rad) * Math.cos(bX * rad) * Math.pow(Math.sin(dLng / 2), 2);
    double y = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));

    return r * y * 1000;
}