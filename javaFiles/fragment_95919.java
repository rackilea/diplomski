public static void main(String[] args) {
    int[] values = { 1, 1, 3, 5, 6, 7 };
    int target = 8;

    for (int i = 0; i < (int) Math.pow(2, values.length); i++) {
        boolean[] bitmap = createBitmap(i, values.length);
        int result = calculateResult(values, bitmap);
        if (result == target) {
            System.out.printf("%s = %d\n", 
                getSumString(values, bitmap),
                result);
        }
    }
}

private static boolean[] createBitmap(int value, int arrayLength) {
    boolean[] bits = new boolean[arrayLength];

    int actual;
    for (int i = bits.length - 1; i >= 0; i--) {
        actual = getValue(bits);
        if (actual == value)
            break;
        else if (actual + (int) Math.pow(2, i) <= value)
            bits[i] = true;
    }

    return bits;
}

private static int getValue(boolean[] bits) {
    int value = 0;
    for (int i = bits.length - 1; i >= 0; i--)
        if (bits[i])
            value += (int) Math.pow(2, i);

    return value;
}

private static int calculateResult(final int[] values, boolean[] used) {
    int sum = 0;
    for (int i = 0; i < used.length; i++)
        if (used[i])
            sum += values[i];
    return sum;
}

private static String getSumString(int[] values, boolean[] used) {
    String sumString = "";
    for (int i = 0; i < used.length; i++)
        if (used[i])
            sumString += values[i] + " ";
    return sumString;
}