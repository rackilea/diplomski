for (int i = 0; i < arr.length; i+=2) {
    if (i + 1 < arr.length) {
        temp2 = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp2;
    }
}