Integer rowsAndColumns = 0;
    Integer startingNumber = 0;

    Scanner input_scanner = new Scanner(System.in);
    System.out.print("How many rows and columns (min 4 & max 20)? ");
    rowsAndColumns = input_scanner.nextInt();

    System.out.print("What is the starting number for your integer filled square (between 0 and 50 inclusive): ");
    startingNumber = input_scanner.nextInt();

    int[][] intMatrix = new int[rowsAndColumns][rowsAndColumns];

    for (int x = 0; x <= (rowsAndColumns - 1); x++) {
        for (int y = x; y <= (rowsAndColumns - 1); y++) {
            intMatrix[y][x] = startingNumber;
            startingNumber++;
        }
    }

    for (int x = 0; x < intMatrix.length; x++) {
        for (int y = 0; y < intMatrix[x].length; y++) {
            System.out.print(intMatrix[x][y] + " ");
        }
        System.out.println("");
    }