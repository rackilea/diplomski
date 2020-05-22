public void displayPlayerMoves() 
{
    System.out.print(playerMoves.size() + " moves: ");
    bool first = true;
    for(int value : playerMoves) {
        if (!first)
            System.out.print(", ");
        first = false;
        System.out.print(value);
    }
    System.out.print('.');
}