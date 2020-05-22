public static char[][] leftDiagonal(char starParam, int dimenParam) {
    char[][] leftD = new char[dimenParam][dimenParam];
    for (int i = 0; i < dimenParam; i++) {
        for (int j = 0; j < dimenParam; j++) { // i -> j
            leftD[i][j] = starParam;  // Gets error here
        }
    }
    return leftD;
}