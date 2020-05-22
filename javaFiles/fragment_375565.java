public class Cup {

    // public fields of the class
    public final int cupSize;    // this is final because a cup does not change size.
    public int cupLevel;    // this is NOT final because level can vary

    // class constructor
    public Cup(int size, int level) {
        cupSize = size;
        cupLevel = level;
    }
}