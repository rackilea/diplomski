// Some where at class level we have the following map declared
    private static final Map remoteEJBHashMap = new HashMap(100, 0.9f);

public static final <T> T getEJBInterface(String jndiLookupName) {
    String jndiName = jndiLookupMap.get(jndiLookupName);
    T ejbInterface = null;
    //T ejbInterface = (T) remoteEJBHashMap.get(jndiLookupName);
    //if (ejbInterface == null) {
        try {
            ejbInterface = (T) ctx.lookup(jndiName);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        //remoteEJBHashMap.put(jndiLookupName, ejbInterface);
    //}
    return ejbInterface;
}