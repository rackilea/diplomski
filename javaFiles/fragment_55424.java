public int[] getSumOfEvensAndOdds(int[] array) {
    // Student code begins here
    int[] res = { 0, 0 };

    if (array == null) {
        return res;
    }
    int len = array.length;
    for (int i = 0; i < len; i++) {
        if (array[i] % 2 == 0) {
            res[0] += array[i];
        } else {
            res[1] += array[i];
        }
    }
    return res;
}