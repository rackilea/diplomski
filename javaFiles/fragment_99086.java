public class ThisIsGarage {

    private int total = 0;

    public ThisIsGarage addValues(int vals) {
        total += vals;
        return this;
    }

    public int tally() {
        return total;
    }
}