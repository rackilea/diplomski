public class SeedObject {
    public final int state;

    public final int value;

    public SeedObject(int state, int value) {
        this.state = state;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.state+"|"+this.value; 
    }
}