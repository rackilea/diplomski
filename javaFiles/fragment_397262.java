public class FlipFlop {
    boolean isWhite;
    public String getCurrent() {
        isWhite = !isWhite;
        return isWhite ? "WHITE" : "BLACK";
    }
}