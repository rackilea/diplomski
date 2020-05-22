public void nestedRemove(Map map, String keyToRemove)
{
    String string = "employee.address.city";
    String[] keys = string.split("\\.");
    Map subMap = null;
    for(int i = 0; i < keys.length -1; i++)
    {
        subMap = subMap.get(keys[i]);
    }
    subMap.remove(keys[i]);
}