public class JndiLookupHelper<T> {

    private T remoteObject;

    @SuppressWarnings("unchecked")
    public T lookup(String name) {
        try {
            remoteObject = (T) InitialContext.doLookup(name);
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return remoteObject;
    }
}