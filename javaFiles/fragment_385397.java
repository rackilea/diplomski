public double bearingTo(Vector target) {
        return Math.PI/2 - (Math.atan2(target.getY() - y, target.getX() - x));
    }

    public static Vector fromPolar(double magnitude, double angle) {
        double flippedAngle = Math.PI/2 - angle;
        return new Vector(magnitude * Math.cos(flippedAngle),
                magnitude * Math.sin(flippedAngle));
    }