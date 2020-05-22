HumanPlayer human = new HumanPlayer();
ComputerPlayer computer = new ComputerPlayer();

while(!human.hasWon() && !computer.hasWon()) { // Remove the loop from getUserInput() !!!
     human.getUserInput();
     computer.getUserInput();
}