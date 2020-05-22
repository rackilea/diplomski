class PieceFactory {     

    public Piece createPiece(String pieceType) throws Throwable{
        Piece piece = null;

        if ("SubPiece1".equals(pieceType)) {
            piece = new SubPiece1();
        } else if ("SubPiece2".equals(pieceType)) {
            piece = new SubPiece2();
        }

        return piece;       
    }
}