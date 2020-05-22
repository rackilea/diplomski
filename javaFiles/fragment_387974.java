public void play() {
    Scanner scan = new Scanner(System.in);
    /* ... */

    while (gameFinished == false) {
        String input = scan.nextLine();
        /* ... */

        boolean highorlow = board.tohighorlow(position);
        boolean succes = board.placeAttempt(position, nextSymbol);
        /* ... */

        if (board.checkWinner("x") == true) {
            System.out.println("x wins");
            scan.close();
        }
        if (board.checkWinner("o") == true) {
            System.out.println("x wins");
            scan.close();
        }
    }
}