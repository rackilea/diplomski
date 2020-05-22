private char[][] makeSeats() {
    char[][] seats = new char[15][4];
    for(int i=0; i<15; i++) {
        for(int j=0; j<4; j++) {
            seats[i][j] = 'O';
        }
    }
    return seats;
}        

public static void method1(char[][] seats) {
    for(char[] row : seats) {
        printRow(row);
    }
}

public static void printRow(char[] row) {
    for (char i : row) {
        System.out.print(i);
        System.out.print("\t");
    }
    System.out.println();
}

public static void main(String[] args) {
    char[][] seats = makeSeats();
    method1(seats);
}