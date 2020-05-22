public class ItemWrapper {
    private final Item item;
    public ItemWrapper(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ItemWrapper && item.getId().equals(((ItemWrapper) obj).item.getId());
    }

    @Override
    public int hashCode() {
        return item.getId().hashCode();
    }
}