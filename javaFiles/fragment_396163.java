class Knight extends Piece {
    @Override Collection<Square> getPossibleMoves() {
        List<Square> possibleMoves = new ArrayList<Square>();
        int[][] offsets = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
        };
        for (int[] o : offsets) {
            Square candidate = location.neighbour(o[0], o[1]);
            if (candidate != null && (candidate.occupyingPiece == null || candidate.occupyingPiece.color != color)) {
                possibleMoves.add(candidate);
            }
        }
        return possibleMoves;
    }
}