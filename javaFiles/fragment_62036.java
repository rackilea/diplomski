for(int i = 0 ; i < 10 ; ++i) {
    String[] digits = fileL[i].split(" ");
    for(int j = 0 ; j < digits.length ; ++j) {
        enemySpawningL[i][j] = digits[j];
    }
}