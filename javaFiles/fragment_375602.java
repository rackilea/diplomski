import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

public class DeadlockThreadExample {

    public static interface DeadlockClass extends Remote {
        public void execute() throws RemoteException;
    }

    public static class DeadlockClassImpl extends UnicastRemoteObject implements DeadlockClass {
        private Object lock = new Object();

        public DeadlockClassImpl() throws RemoteException {
            super();
        }

        public void execute() throws RemoteException {
            try {
                System.out.println("execute()::start");

                synchronized (lock) {
                    System.out.println("execute()::Entered Lock");
                    DeadlockClass deadlockClass = (DeadlockClass) Naming.lookup("rmi://localhost/DeadlockClass");
                    deadlockClass.execute();
                }
                System.out.println("execute()::Exited Lock");
            } catch (NotBoundException e) {
                System.out.println(e.getMessage());
            } catch (java.net.MalformedURLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("execute()::end");
        }
    }

    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        DeadlockClassImpl deadlockClassImpl = new DeadlockClassImpl();
        Naming.rebind("DeadlockClass", deadlockClassImpl);
        DeadlockClass deadlockClass = (DeadlockClass) Naming.lookup("rmi://localhost/DeadlockClass");
        deadlockClass.execute();
        System.exit(0);
    }
}