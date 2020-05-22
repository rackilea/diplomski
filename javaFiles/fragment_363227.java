public class ItemCost implements Serializable {
    private Item item;

    @ManyToOne //owning side
    @JoinColumn(name = "itemId") //the foreign key (the primary key of "Item")
    @MapsId("itemId")    //is shared with the compound primary key of "ItemCost"
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}