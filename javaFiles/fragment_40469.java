public class Items
{
    public void add(Item item) { ... }
}

public class RedItems extends Items
{
    @Override
    public void add(Item item)
    {
        if (!item.isRed())
        {
            throw new NotRedItemException();
        }
        super.add(item);
    }
}

public class BigRedItems extends RedItems
{
    @Override
    public void add(Item item)
    {
        if (!item.isBig())
        {
            throw new NotBigItemException();
        }
        super.add(item);
    }
}