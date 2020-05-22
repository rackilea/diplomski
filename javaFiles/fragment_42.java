class TestMap
{
    Map<Key, Value> synchronizedMap = 
        Collections.synchronizedMap(new HashMap<Key, Value>());

    public Set<Key> getAllKeys()
    {
        return synchronizedMap.keySet();
    }
}