public class Serwer extends PortableRemoteObject implements MyInterface {

    public Serwer() throws RemoteException {
        super();
    }

    @Override
    public String echo(String napis) throws RemoteException {
        return "echo" + napis;
    }

    @Override
    public int dodaj(int wrt1, int wrt2) throws RemoteException {
        return wrt1 + wrt2;
    }

    public static void main(String[] args){
        try {
            Serwer ref = new Serwer();
            // Context ctx = new InitialContext();
            // ctx.rebind("myinterfaceimplementacja", ref);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}