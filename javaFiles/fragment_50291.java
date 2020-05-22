public static int[] overGivenPounds(int x, int[] array) {
    int size = 0;

    for (int value : array) {
        if (satisfies(x, value)) {
            size++;
        }
    }

    int[] result = new int[size];
    // ??? -> for you to complete this
    for (int value : array) {
        if (satisfies(x, value)) {
            // ??? -> for you to complete this
        }
    }

    return result;
}