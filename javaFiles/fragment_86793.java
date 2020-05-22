for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
        for (int e = 2; e < table[i][j]; e++) {
            if (table[i][j] % e == 0) {
                        prime = false;
            }
        }
        if (prime == true) {
            sum += table[i][j];
        } else {
        }
        prime = true;
    }
}