public static void play(String word, char[][] puzzle) {
    String foundMessage = "The word %s was found by the method %s beginnning in cell%n";
    for (int i = 0; i < puzzle.length; i++) {
        for (int j = 0; j < puzzle[0].length; j++) {
            if (checkUp(puzzle, word, i, j)) {
                System.out.printf(foundMessage, word, "checkUp");
                return;
            } else if (checkDown(puzzle, word, i, j)) {
                System.out.printf(foundMessage, word, "checkDown");
                return;
            } else if (checkRight(puzzle, word, i, j)) {
                System.out.printf(foundMessage, word, "checkRight");
                return;
            } else if (checkLeft(puzzle, word, i, j)) {
                System.out.printf(foundMessage, word, "checkLeft");
                return;
            }
        }
    }
    System.out.println("The word " + word + " was not in the puzzle");
}