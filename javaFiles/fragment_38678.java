import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRMIClient {
    public static void main(String args[]) {

        System.setProperty("java.security.policy","file:///tmp/test.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Calculator";
            String serverIP = "11.11.11.11"; // or localhost if client and server on same machine.
            int serverPort = 1099;
            Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
            MyCalc mycalc = (MyCalc) registry.lookup(name);
            int result = mycalc.add(10, 20);
            System.out.println("Result:" + result);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}