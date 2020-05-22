public static double toMillesPerHour(double kilomettersPerHour) {
    if (kilomettersPerHour < 0) {
        throw new IllegalArgumentException("Negative value detected");
    }

    return kilomettersPerHour / 1.60934;
}