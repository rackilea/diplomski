int i = 0;
for (int j = 0; j < matrix.length; j++) {
    for (int h = 0; h < matrix[j].length; h++) {
        matrix[j][h] = msgArray[i++];
    }
}