private Set<Object> singletons = new HashSet<Object>();

public MasterDataRestEndpointApplication() {
    singletons.add(new CurrencyEndpoint());
}

@Override
public Set<Class<?>> getClasses() {
    HashSet<Class<?>> set = new HashSet<Class<?>>();
    return set;
}

@Override
public Set<Object> getSingletons() {
    return singletons;
}