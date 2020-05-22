public boolean play(Play player1, Play player2) throws UnsuportedPlayException{
    // rock wins scissors
    if(player1 == Play.ROCK && player2 == Play.SCISSORS)
        return true;
    if(player2 == Play.ROCK && player1 == Play.SCISSORS)
        return false;

    //rock loses to paper
    if(player2 == Play.ROCK && player1 == Play.PAPER)
        return true;
    if(player1 == Play.ROCK && player2 == Play.PAPER)
        return false;

    //paper loses to scissors
    if(player1 == Play.PAPER && player2 == Play.SCISSORS)
        return false;
    if(player2 == Play.PAPER && player1 == Play.SCISSORS)
        return true;
    throw new UnsuportedPlayException("That play is not yet available.");
}