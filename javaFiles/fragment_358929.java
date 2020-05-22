public boolean contains(Object value)
{
    return contains(value, 0);
}
private boolean contains(Object value, int index)
{
    if (index > size)
    {
        return false;
    }
    else if(elementData[index] == value && elementData[index] != null)
    {
        return true;
    }
    else
    {
        return contains(value, ++index);
    }
}