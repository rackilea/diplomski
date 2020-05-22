public void movePiece(Piece piece, int dx, int dy) {
  // Save current position, so we can erase the piece.
  int oldX = piece.getX();
  int oldY = piece.getY();

  // Update the location.
  piece.setX(oldX + dx);
  piece.setY(oldY + dy);

  // Remove piece from old position
  board[oldX][oldY].clear();

  // Add it to the new position.
  addPiece(piece);
}