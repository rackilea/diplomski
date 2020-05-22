How many people are playing?
Please enter the number of people playing. You must have at least three players, and no more than seven.
10
Please enter the number of people playing. You must have at least three players, and no more than seven.
toto
Please enter the number of people playing. You must have at least three players, and no more than seven.
tutu
Please enter the number of people playing. You must have at least three players, and no more than seven.
22
Please enter the number of people playing. You must have at least three players, and no more than seven.
6


    Scanner input = new Scanner(System.in);
    System.out.println("How many people are playing?");

    int numPlayers = 0;
    while (numPlayers < 3 || numPlayers > 7) {
        System.out.println("Please enter the number of people playing. You must have at least three players, and no more than seven.");
        if (!input.hasNextInt()) {
            input.next();
        }
        else {
            numPlayers = input.nextInt();
        }
    }
    game.setNumPlayers(numPlayers);
    input.close();