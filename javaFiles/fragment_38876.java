public void choose(int r, int c, int player) throws UnavailableCellException
{
    if (this.board[r][c] == 0) { // assuming "0" means "free cell"
        // valid, place it
        this.board[r][c] = player;
    } else {
        // already used, throw exception
        throw new UnavailableCellException("That spot is taken!!");
    }
}