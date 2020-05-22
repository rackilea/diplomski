private static boolean isSteppingNumber(long v) {
    char[] arr = String.valueOf(v).toCharArray();
    for (int i = 0; i + 1 < arr.length; i++) {
        // The - '0' is really only useful for debugging.
        int a = arr[i] - '0', b = arr[i + 1] - '0';
        if (Math.abs(b - a) != 2) {
            return false;
        }
    }
    return true;
}