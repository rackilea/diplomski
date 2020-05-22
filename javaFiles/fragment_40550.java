private final ItemStack getDrops(Block b)
{
    for(ItemStack im : b.getDrops())
    {
        return im;
    }
    return null;
}