public static boolean checkunique(int testValue, int[] array) {
    for (int i = 0; i < array.length; i++) {
        if (testValue == array[i]) {
            return false;
        }
    }
    return true;
}