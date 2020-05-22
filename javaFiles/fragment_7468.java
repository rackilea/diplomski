public static double evaluate(int[] array) {
    double ruleSat = 0;
    for (int index = 0; index < array.length; index++) {
        if (index != array.length-1) {
            if ((array[index] == array[index + 1]) && (index % 2 == 0)) {
                ruleSat++;
            }
        }
    }
    return ruleSat;
}