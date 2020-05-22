public interface IdentityMapAccessor {
    /**
     * PUBLIC:
     * Used to print all the Objects in the identity map of the given Class type.
     * The output of this method will be logged to this session's SessionLog at SEVERE level.
     */
    public void printIdentityMap(Class theClass);

    /**
     * PUBLIC:
     * Used to print all the Objects in every identity map in this session.
     * The output of this method will be logged to this session's SessionLog at SEVERE level.
     */
    public void printIdentityMaps();
}