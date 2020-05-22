//here i use `id`, which i assume is a member of a `MyObject` class, 
//and this class is used to represent the data of the items inside your list:
private int getItemPositionByObjectId(final long id)
{
    for (int i = 0; i < adapter.getCount(); i++)
    {
        if (((MyObject)adapter.getItem(i)).getId() == id)
            return i;
    }
    return -1;
}