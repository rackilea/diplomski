//How many runs you want
    int numRuns = 7;

    for (int x = 0; x < numRuns; x++) {
        Random ran = new Random();
        int dieOne = ran.nextInt(6) + 1;
        int dieTwo = ran.nextInt(6) + 1;
        System.out.format("| Die 1:%3d| Die 2:%3d| Total:%3d|\n", dieOne, dieTwo, dieOne + dieTwo);
    }