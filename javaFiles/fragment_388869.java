@Override
public boolean equals(Object object)
{
    Item item = (Item)object;
    return value.equals(item.getValue());
}