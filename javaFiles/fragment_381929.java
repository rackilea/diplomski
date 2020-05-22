public class Piece {
    private PieceType type;

    public Piece(PieceType type) {
        if (type == null) {
            throw new NullPointerException("the piece type is mandatory");
        }
        this.type = type;
    }

    public PieceType getType() {
        return type;
    }

    public Color getColor() {
        if (type == PieceType.BLACK) {
            return Color.BLACK;
        }
        else {
            return Color.RED;
        }
    }
}