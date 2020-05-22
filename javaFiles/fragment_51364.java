for (int i = 0; i < array.length - 1; i++) {
    int currentMin = array[i];
    int currentMinIndex = i;
    for (int j = i + 1; j < array.length; j++) {
        if (array[j] < currentMin) {
            currentMinIndex = j;
            currentMin = array[j];
        }
    }
    array[currentMinIndex] = array[i];
    array[i] = currentMin;
}