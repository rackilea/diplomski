public int[][] replace(int[][] numbers, int n) {
    int[][] temp = numbers; // /!\ temp points to the same array as numbers
    int cont = 0;  // why not using i
    int cont2 = 0; // why not using j
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i < n - 1 && temp[cont][cont2] == temp[cont + 1][cont2]) {
                numbers[cont][cont2] = 1; // /!\ temp=numbers is also modified
                numbers[cont + 1][cont2] = 1;
                cont++; // /!\ ~= i*j => index out of bound
            }
            if (j < n - 1 && temp[cont][cont2] == temp[cont][cont2 + 1]) {
                numbers[0][1] = 1; // why fixed indexes ?
                numbers[0][0] = 1;
                cont2++;
            }
        }
        cont2 = 0; // cont2 seems equivalent to j
    }
    return numbers;
}