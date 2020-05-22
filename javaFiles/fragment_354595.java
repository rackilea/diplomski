String result = "";

    Scanner in = new Scanner(System.in);
    System.out.print("Enter a number ");
    int numberOfCuts = in.nextInt();

    int pieces = 1;
    int cutCount = 1;

    do {
        result += " " + pieces;

        pieces += cutCount;
        cutCount++;
    }
    while (cutCount <= numberOfCuts);

    System.out.println(result);