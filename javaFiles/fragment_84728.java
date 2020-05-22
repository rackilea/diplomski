Map.Entry<Foo, Bar> maxEntry = null;

for (Map.Entry<Foo, Bar> entry : map.entrySet())
{
    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
    {
        maxEntry = entry;
    }
}