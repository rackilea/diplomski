// assumes the given integer values are positive
public static double calculate(int a, int c) {
    final double coefficient = 1.1;
    final int multiplier = 6;
    final int increment = 500;
    final int baseValue = 3000;

    if (a < 12) {
        return (baseValue + c) * coefficient;
    }

    if (a <= 36) {
         // int division is truncated to nearest int value
        int result = ((a / multiplier) * increment) + baseValue + c;
        if (a % multiplier == 0) {
            return result;
        } else {
            return result * coefficient;
        }
    }
    throw new IllegalArgumentException("Invalid value for a (" + a + ")");
}