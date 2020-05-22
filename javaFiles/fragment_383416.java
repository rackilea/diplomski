public Collection<ObjectWrapper> getValues()
{
    synchronized(LOCK)
    {
        return cachedObjects.values();
    }
}

public Set<Object> getKeys()
{
    synchronized(LOCK)
    {
        return cachedObjects.keySet();
    }
}