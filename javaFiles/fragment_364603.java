public class MyEndpointConfigurator extends ServerEndpointConfig.Configurator
    private Set<MyEndpoint> endpoints = Collections.synchronizedSet(new HashSet<>());

    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
        try {
            T endpoint = endpointClass.newInstance();
            MyEndpoint myEndpoint = (MyEndpoint) endpoint;
            myEndpoint.setConfigurator(this);
            endpoints.add(myEndpoint);
            return endpoint;
        } catch (IllegalAccessException e) {
            throw new InstantiationException(e.getMessage());
        }
    }

    // Call this from MyEndpoint.onClose()
    public void removeInstance(MyEndpoint endpoint) {
        endpoints.remove(endpoint);
    }
}