public int Count(int c) {
    int elements = 0;
    for (int i = 0; i < index; i++) {
        if (array[i] == c) {
            elements++;
        }
    }
    return elements;
}