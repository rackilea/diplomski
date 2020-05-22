public enum ItemType {
    HELM(4),
    AMULET(1),
    WEAPON(),
    BODY_ARMOR(6);

    private int itemSize;

    ItemType() {

    }

    ItemType(int itemSize) {
        this.itemSize = itemSize;
    }

    public int getItemSize() {
        return itemSize;
    }
}