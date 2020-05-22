public class SerializedPlayer extends Player implements Serializable {
    public SerializedPlayer() {}
    public SerializedPlayer(Player playerToClone) {
        this.setField1(playerToClone.getField1());
        // Set all the fields
    }
}