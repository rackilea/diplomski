public Pattern(int n) {
    if (n < 5) {
        field = new char[5][5];
    } else {
        field = new char[n][n];
    }
}