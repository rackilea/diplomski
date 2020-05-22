public int getNumDots() {
    int numDots = 0;
    for (String row: list) {
        for (int i = 0; i < row.length(); i++) {
            if (charAt(i) == '.') {
                numDots++;
            }
         }
    }
    return numDots;
}