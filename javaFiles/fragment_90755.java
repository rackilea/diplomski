// Would be nice if the 2 types shared a common super type.   
public ArrayIterator<Object> query(String table, String field, String criterion)
{
    // WARNING, this is a raw generic type, and provides no type safety
    ArrayIterator result = null;

    if (table.equals("MyTable")
    {
        result = MyTable.queryMe(field, criterion);
    }
    else if (table.equals("YourTable")
    {
        result = YourTable.queryYou(field, criterion);
    }
    return (ArrayIterator<Object>) result.
}