@Override
public T create(CreationalContext<T> arg0) {
    // Some classloading confusion occurs here in my case, but I guess they're of no interest to you

    try {
        Hashtable contextProps = new Hashtable();
        contextProps.putAll(jndiProperties);
        Context context = new InitialContext(contextProps);
        Object serverSide = context.lookup(jndiName);
        return interfaceClass.cast(serverSide);
    } catch (NamingException e) {
        // An unchecked exception to go through weld and break the world appart
        throw new LookupFailed(e);
    }
}