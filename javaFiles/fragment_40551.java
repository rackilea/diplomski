private final ItemStack getDrops(Block b)
{
    ItemStack item = null;
    for(ItemStack im : b.getDrops())
    {
        item = im;
    }
    return item;
}