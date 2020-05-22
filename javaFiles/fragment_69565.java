public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Ask array size to the user
    System.out.println("How many rows: ");
    int rows= sc.nextInt();
    System.out.println("How many columns: ");
    int columns= sc.nextInt();

    // Fill array with random numbers
    int[][] testArray = new int[rows][columns];
    for (int i=0; i<testArray.length; ++i) {
        for (int j=0; j<testArray[i].length; ++j) {
            testArray[i][j] = randomNumber();
        }
    }

    // TO DISPLAY ARRAY
    printArray(testArray);
} // end main