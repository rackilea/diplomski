while (current != null) {

    if (current.piece.col == col && current.piece.row == row) {

        System.out.print(current.piece.pieceType);

        foundPiece = true;
    }

    current = current.next; // you might want to add this to your code
}