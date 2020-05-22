public class EchoServiceImpl extends UnicastRemoteObject implements EchoService {

    private static final long serialVersionUID = -3671463448485643888L;

    private String user;

    public EchoServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String echo(String msg) throws RemoteException {
        return this.user + ": " + msg;
    }

    @Override
    public String getUser() throws RemoteException {
        return this.user;
    }

    @Override
    public void setUser(String user) throws RemoteException {
        this.user = user;
    }
}