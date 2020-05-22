public class PojoLocator extends Locator<DatastoreObject, String>
{
    @Override
    public DatastoreObject find(Class<? extends DatastoreObject> clazz, String id)
    {
        Key<DatastoreObject> key = Key.create(id);
        return ofy.load(key);
    }

    @Override
    public String getId(DatastoreObject domainObject)
    {
        if (domainObject.getId() != null)
        {
            Key<DatastoreObject> key = ofy.fact().getKey(domainObject);
            return key.getString();
        } else
            return null;
    }
}