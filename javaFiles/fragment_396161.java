void move(Square destination) {
    if (!getPossibleMoves().contains(destination) {
        throw new IllegalMoveException();
    }

    this.location.occupyingPiece = null;
    this.location = destination;
    this.location.occupyingPiece = this;
}