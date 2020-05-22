class Pawn extends Piece {
    @Override Collection<Square> getPossibleMoves() {
        List<Square> possibleMoves = new ArrayList<Square>();
        int dy = color == Color.white ? 1 : -1;
        Square ahead = location.neighbour(0, dy);
        if (ahead.occupyingPiece == null) {
            possibleMoves.add(ahead);
        }
        Square aheadLeft = location.neighbour(-1, dy);
        if (aheadLeft != null && aheadLeft.occupyingPiece != null && aheadLeft.occupyingPiece.color != color) {
            possibleMoves.add(aheadLeft);
        }
        Square aheadRight = location.neighbour(1, dy);
        if (aheadRight != null && aheadRight.occupyingPiece != null && aheadRight.occupyingPiece.color != color) {
            possibleMoves.add(aheadRight);
        }
        return possibleMoves;
    }
}