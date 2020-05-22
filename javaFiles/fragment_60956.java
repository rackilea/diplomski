public interface IPiece<E> {
  boolean isFriendlyTo(E piece);
  ...
}
public abstract class AbstractChessPiece implements IPiece<AbstractChessPiece> {
  ...
  @Override
  public boolean isFriendlyTo(AbstractChessPiece piece) {
    return this.color() == piece.color();
  }
  ...
}