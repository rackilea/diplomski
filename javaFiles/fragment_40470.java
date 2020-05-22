public class NaughtyItems extends RedItems
{
    @Override
    public void add(Item item)
    {
        // I don't care if it's red or not. Take that, RedItems!
        super.super.add(item);
    }
}