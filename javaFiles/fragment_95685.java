@Remote
public interface OrangeRemote extends java.rmi.Remote {

    public void doSomething() throws RemoteException;
}

@Stateless
public class OrangeBean implements OrangeRemote {

    @Override
    public void doSomething() {
        //...
    }
}