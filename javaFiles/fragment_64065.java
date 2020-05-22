Scanner sc = new Scanner(new File("maze.txt"));
    int rows1 = sc.nextInt();
    int columns1 = sc.nextInt();

    char[][] treasureMaze = new char[rows1][columns1];

    for (int i = 0; i < rows1; ++i) {
        String line = sc.nextLine();