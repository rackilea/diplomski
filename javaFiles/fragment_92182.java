public static void merge(char[] string, char[] left, char[] right) {
    int i1 = 0;
    int i2 = 0;
    for (int i = 0; i < string.length; i++) {
        if (i1 < left.length && i2 < right.length) {
            if (left[i1] - right[i2] <= 0) {
                string[i] = left[i1];
                i1++;
            } else {
                string[i] = right[i2];
                i2++;
            }
        } else if (i2 >= right.length) {
            string[i] = left[i1];
            i1++;
        } else {
            string[i] = right[i2];
            i2++;
        }
    }
}