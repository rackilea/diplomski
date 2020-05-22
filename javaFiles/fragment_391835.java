public Item findItem(String name)
{
    for(Item item : inventory)
    {
        if(item.getName().equalsIgnoreCase(name))
        {
            return item;
        }
    }

    return null;
}