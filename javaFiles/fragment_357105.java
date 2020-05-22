public class CellRoomObject {

    String itemName;
    int itemNumber;
    boolean ok;

    public CellRoomObject(String itemName, int itemNumber, boolean ok) {
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.ok = ok;
    }

    @Override
    public String toString() {
        return this.itemName;
    }


}