public abstract class Operator<T extends Enum<T>> {
  public final Class<T> symbol;
  public Operator(Class<T> symbol) { this.symbol = symbol; }
}

public enum BinarySymbol { PLS, MIN, MUL, DIV }

public class Binary extends Operator<BinarySymbol> {
  public Binary(Object operand1, Object operand2, BinarySymbol symbol) {
    super(symbol);
  }
}