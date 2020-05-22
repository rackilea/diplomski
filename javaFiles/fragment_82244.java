// ...
for (int i = 0; i < a.length; i++) {
    for (int j = 0; j < a[i].length; j++) {
        if (a[i][j] > limit) {
            biggerLimit++;
        }
    }
}