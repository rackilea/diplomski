public int[] findUnique(int[] data) {
    int[] unique = new int[data.length];
    int x = 0;
    for (int i = 0; i < data.length; i++) {
        boolean uni = true;
        for (int j = i + 1; j < data.length; j++) {
            if (data[i] == data[j]) {
                uni = false;
                break;
            }
        }
        if (uni) {
            unique[x++] = data[i];
        }
    }
    return unique;
}