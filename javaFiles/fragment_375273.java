//How many runs you want
    int numRuns = 7;

    System.out.println("-----------------");
    System.out.println("|Die1|Die2|Total|");
    System.out.println("-----------------");
    for (int x = 0; x < numRuns; x++) {
        Random ran = new Random();
        int dieOne = ran.nextInt(6) + 1;
        int dieTwo = ran.nextInt(6) + 1;
        System.out.format("|%4d|%4d|%5d|\n", dieOne, dieTwo, dieOne + dieTwo);
    }
    System.out.println("-----------------");