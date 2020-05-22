import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRMIServer {
    public static void main(String[] args) throws Exception {

        System.setProperty("java.security.policy","file:///tmp/test.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Calculator";
            MyCalc engine = new MyCalcImpl();
            MyCalc stub = (MyCalc) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry(1099);
            System.out.println("Registering Calculator Object");
            registry.rebind(name, stub);
        } catch (Exception e) {
            System.err.println("Exception:" + e);
            e.printStackTrace();
        }
    }
}