// strict one - disallow nulls for everything
public <T> static int linearSearch(final T[] data, final T value)
{
    int index;

    if(data == null)
    {
        throw new IllegalArgumentException("data cannot be null");
    }

    if(value == null)
    {
        throw new IllegalArgumentException("value cannot be null");
    }

    index = -1;

    for(int i = 0; i < data.length; i++)
    {
        if(data[i] == null)
        {
            throw new IllegalArgumentException("data[" + i + "] cannot be null");
        }

        if(data[i].equals(value))
        {
            index = i;
            break; // stop looking
        }
    }    

    return (index);
}