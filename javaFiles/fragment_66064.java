public static String toString(EntityProxy entityProxy)
{
    DefaultProxyStore store = new DefaultProxyStore();
    Swap.requestFactory.getSerializer(store).serialize(entityProxy);
    return store.encode();
}