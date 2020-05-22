public abstract class Piece {
    public abstract String getColor();

    public final boolean isAlly(Piece otherPiece) {
        return this.getColor().equals(otherPiece.getColor());
    }
}

public class RedPiece extends Piece {
    @Override
    public String getColor() {
        return "red";
    }
}