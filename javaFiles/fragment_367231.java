int counter = 0;
for (int i = 0; i < a.length; i++) {
    for(int j = 0; j < a[i].length; j++) {
        b[counter] = a[i][j];
        counter++;
    }
}