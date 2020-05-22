public class Item {
    private int field1;
    public Item() { }

    public Item(Item item) {
       this.field1 = item.field1;
    }
}