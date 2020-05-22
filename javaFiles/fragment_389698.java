public static double getArmX(double length, double angle) {
    return Math.cos(angle) * length;
}

public static double getArmY(double length, double angle) {
    return Math.sin(angle) * length;
}