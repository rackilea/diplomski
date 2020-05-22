public class MyConfigurator extends javax.websocket.server.ServerEndpointConfig.Configurator
{
    private final ManagerObject aSocketManagerObject;

    public EventsConfigurator(ManagerObject aSocketManagerObject)
    {
        this.aSocketManagerObject = aSocketManagerObject;
    }

    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException
    {
        return (T) new MyEndpoint(aSocketManagerObject); // This constructor to be added to your MyEndpoint class
    }
}