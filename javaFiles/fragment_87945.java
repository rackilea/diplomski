private static final int MIN = -180;
private static final int MAX = 180;

public static void main(String[] args) {
    System.out.println(keepInRange(-150 + 90));
    System.out.println(keepInRange(0 + 90));
    System.out.println(keepInRange(150 + 90));
    System.out.println(keepInRange(-150 - 90));
}

private static int keepInRange(final int value) {
    if (value < MIN) {
        /*
         * subtract the negative number "MIN" from "value" and
         * add the negative result to "MAX" (which is like subtracting the absolute value
         * of "value" from "MAX)
         */
        return MAX + (value - MIN);
    }
    if (value > MAX) {
        /*
         * subtract the number "MAX" from "value" and to get exceeding number
         * add it to "MIN"
         */
        return MIN + (value - MAX);
    }
    return value;
}