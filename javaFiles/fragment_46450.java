public class LTile {
    char letter;
    private int value;
    private int id; // instance id
    private static int CURRENT_ID = 0; // static counter from where the instance ids will be drawn

    public LTile() {
        // Call the other constructor to avoid unnecessary repetition
        this('?', 0);
    }

    public LTile(char letter, int value) {
        this.letter = letter;
        this.value = value;
        this.id = LTile.CURRENT_ID++;
    }

    // rest of the code

    public int getID() {
        return this.id;
    }

    public String toString() {
        return "["+this.id+":" + this.letter+","+this.value+"]";
    }
}