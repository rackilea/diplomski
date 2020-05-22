public static double perfectCity(double x1, double y1, double x2, double y2) {
    return travelOnAxis(x1, x2) + travelOnAxis(y1, y2);
}

private static double travelOnAxis(double from, double to) {
    if (Math.floor(from) == Math.floor(to)) {
        double dist = Math.abs((from % 1) + (to % 1));
        return Math.min(dist, 2 - dist);
    } else {
        return Math.abs(from - to);
    }
}