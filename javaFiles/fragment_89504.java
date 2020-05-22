public class Piece implements Comparable {

    private String symbol;
    private int value;

    public Piece(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "symbol='" + symbol + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Piece) {
            Piece other = (Piece)o;

            return this.value - other.value;
        } else {
            return 0;
        }
    }
}