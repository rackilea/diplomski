foreach (List<ItemNY> level in highU.getLevels())
{
    foreach (var item in level)
    {
        if (item.getU() < min)
        {
            level.Remove(item);  //Error, you are modifying a collection being enumerated
            highU.decreaseCount();
        }
    }
}