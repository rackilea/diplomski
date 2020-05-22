public void mouseClicked(MouseEvent e) {
    Position clickPosition = getSquare(e.getX(), e.getY());

    if(this.selectedPiece.getType() == PieceType.NONE) {
        // Attempts to select the piece that was just clicked
        Piece piece = b.getPiece(clickPosition);

        if(piece.getType() != PieceType.NONE) {
            this.selectedPiece = b.getPiece(clickPosition);
            this.selectedPiecePosition = clickPosition;
        }
    } else {
        // Attempts to move the selected piece
        try {
            this.playerMove = b.getMove(selectedPiecePosition, clickPosition);
            synchronized(this) {
                this.notify();
            }
        } catch(InvalidMoveException ex) {

        }
        this.selectedPiece = new NonePiece();
        this.selectedPiecePosition = new Position(0, 0);
        updateCurrentHover(e.getX(), e.getY());
    }

    repaint();
}