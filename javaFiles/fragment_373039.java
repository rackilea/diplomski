while (true) {
    // Play the game here
    // Play again?
    boolean isPlayingAgain = true;
    while (true) {
        System.out.println("play another game?(y/n)");
        String playingAgainResponse = input.next();
        if (playingAgainResponse.equalsIgnoreCase("y")) {
            break;
        } else if (playingAgainResponse.equalsIgnoreCase("n")) {
            System.out.println("Goodbye");
            isPlayingAgain = false;
            break;
        }
    }
    if (!isPlayingAgain) {
        break;
    }
}