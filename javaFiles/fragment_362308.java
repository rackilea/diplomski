for (int i = 0; i < arr.length; i++) {
    row++;
    col = -1;
    for (int j = arr[i].length / 2 - 1; j >= 0; j--) { //here changed arr[i].length to arr[i].length / 2
        col++; 
        arr[row][col] = A[i][j]; //for this you do not need arr and you can directly work on A and return it
    }
}