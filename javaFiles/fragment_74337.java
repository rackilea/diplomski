double[] newArray = new double[3];
for (double[] array : db_results) {
    for (int i = 0; i < 3; ++i) {
        newArray[i] += array[i];
    }
}