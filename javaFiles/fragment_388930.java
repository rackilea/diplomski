public enum PersistenceHandlerFactory
{
    POSTAL_ADDRESS
    {
        @Override Object newField()
        {
            return new PostalAddress();
        }
    },
    ...;

    public abstract Object newField();
}