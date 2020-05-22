static int uniqueValues(int[] c) {
    int uniqueValues = c.length;
    for (int i = 0; i < c.length; i++) {
        while (c[i] == c[i + 1] && i + 1 < c.length && c[i] > c[i+1] ) {
            i++;
            uniqueValues--;
        }
    }
    return unique;
}