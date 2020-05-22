Player player = null; // player should never be null as you would have thrown an exception, but for the sake of completeness
if (selection == 1){
    player = new HumanPlayer();
} else if (selection == 2){
    player = new ComputerPlayer();
} else {
    throw new IllegalArgumentException("invalid answer");
}
player.play();