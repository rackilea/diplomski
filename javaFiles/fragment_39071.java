public class Item implements Cloneable {
    ...
    public Item clone() {
        return (Item) super.clone();
    }
}