public Collection<ObjectWrapper> getValues()
{
    synchronized(LOCK)
    {
        return new ArrayList<>(cachedObjects.values());
    }
}

public Set<Object> getKeys()
{
    synchronized(LOCK)
    {
        return new HashSet<>(cachedObjects.keySet());
    }
}