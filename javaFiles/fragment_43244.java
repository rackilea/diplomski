public class RmiServer extends UnicastRemoteObject implements RmiInterface
{
    private static final long serialVersionUID = 1L;

    public RmiServer() throws RemoteException
    {
        super();
    }

    public String random() throws RemoteException
    {
        return "Helo World! "+(new Random()).nextInt(100);
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException
    {
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        Naming.rebind("myServer", new RmiServer());
    }
}