public interface RemotePeer extends Remote {

    public abstract void displayInf(String inf) throws RemoteException;

    public abstract void exit() throws RemoteException;

    public abstract boolean isActive() throws RemoteException;
}