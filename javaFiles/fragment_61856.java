public static void method1() {
    char[][] seats = new char[15][4];
    int i, j;
    char k = 'O';
    for(i=0; i<15; i++) {
        for(j=0; j<4; j++) {
            seats[i][j]=k;
        }
    }
    for(char[] row : seats) {
        printRow(row);
    }
}

public static void main(String[] args) {
    method1();
}