public class Item
{
    /** Name is the first part of the item. Ex. Long Bow */
    private String name;

    private ItemType type;
    /**
     * Defines what an item object is.
     * @param name of item.
     */
    public Item(ItemType type, String name)
    {
        this.type = type;
        this.name = name;
    }

    public int getItemSize()
    {
        int size = type.getItemSize();
        if (size == 0)
            size = Constants.HASH_MAP.get(name);
        return size;
    }

    public String getName()
    {
        return name;
    }

    public ItemType getType() {
        return type;
    }
}