public static void printRow(int rowNumber) {
    for (int i = 0; i < 11; i++) {
        System.out.print( epidemicArray[rowNumber][i] + " ");
    }
    System.out.println();
}

public static void main(String[] args) {

    updateArray();
    for (int i = 0; i < 3; i++) {
        printRow(i);
    }
}