public static boolean willAdditionOverflow(int left, int right) {
    try {
        Math.addExact(left, right);
        return false;
    } catch (ArithmeticException e) {
        return true;
    }
}

public static boolean willSubtractionOverflow(int left, int right) {
    try {
        Math.subtractExact(left, right);
        return false;
    } catch (ArithmeticException e) {
        return true;
    }
}