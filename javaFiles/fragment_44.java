class TestMap
{
    Map<Key, Value> synchronizedMap = 
        Collections.synchronizedMap(new HashMap<Key, Value>());

    public Object getSynchronizationMonitor()
    {
        return synchronizedMap;
    }
}