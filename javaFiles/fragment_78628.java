public static boolean determineWinner(String computer, String user){
    System.out.println (" Computer Choice: " + computer);
    System.out.println ("Your Choice : " + user);
    if (computer.compareTo( "Rock" ) == 0 && user.compareTo  ("Scissors") == 0)
    System.out.println (" Computer wins! Better luck next time!");
    if (computer.compareTo("Scissors")== 0 && user.compareTo("Paper") == 0)
    System.out.println (" Computer wins! Better luck next time!");
    if (computer.compareTo("Paper") == 0 && user.compareTo("Rock") == 0)
    System.out.println (" Computer wins! Better luck next time!");
    if (computer.compareTo("Rock") == 0 && user.compareTo("Paper") == 0)
    System.out.println (" You win!!");
    if (computer.compareTo("Scissors") == 0 && user.compareTo("Rock") == 0)
    System.out.println (" You win!!");
    if (computer.compareTo("Paper") == 0 && user.compareTo("Scissors") == 0)
    System.out.println (" You win!!");
    else if (computer.compareTo(user) == 0 ){
        System.out.println(" Tie! the game must be played again.");
        return false;
    }
    return true;
}