public static void printRow(int rowNumber) {
    for (int i = 0; i < 11; i++) {
        System.out.print( (char)epidemicArray[rowNumber][i] + " ");
    }
    System.out.println();
}