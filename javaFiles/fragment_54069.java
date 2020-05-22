// enum type, better than "magic numbers"
public enum Insect {
    ANT,
    DOODLEBUG;
}

public class Cell {

    // the insect placed in this cell
    private Insect insect;

    public Cell() {
        // cell starts without any insect
        this.insect = null;
    }

    public Insect getInsect() {
        return insect;
    }

    public void setInsect(Insect insect) {
        this.insect = insect;
    }

    // check if cell already has an insect
    public boolean isOccupied() {
        return this.insect != null;
    }
}