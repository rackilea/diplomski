public class EchoServiceFactoryImpl extends UnicastRemoteObject implements
    EchoServiceFactory {

private static final long serialVersionUID = 6625883990856972736L;

protected EchoServiceFactoryImpl() throws RemoteException {
    super();
    System.setProperty("java.rmi.server.codebase", EchoServiceFactory.class.getProtectionDomain().getCodeSource().getLocation().toString());

    System.setProperty("java.security.policy", "/java.policy");

    if (System.getSecurityManager() == null) {
        System.setSecurityManager(new SecurityManager());
    }

    try {
        Registry registry = LocateRegistry.getRegistry("localhost");
        registry.rebind("EchoService", this);
        System.out.println("Echo service factory registered.");
    } catch (Exception e) {
        System.err.println("Error registering echo service factory: "
                + e.getMessage());
    }
}

@Override
public EchoService createEchoService() throws RemoteException {
    return new EchoServiceImpl();
}

public static void main(String[] args) {
    try {
        new EchoServiceFactoryImpl();
    } catch (RemoteException e) {
        System.err.println("Error creating echo service factory: "
                + e.getMessage());
    }
}