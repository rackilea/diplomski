import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyCalc extends Remote{
    int add(int a, int b) throws RemoteException;
}




import java.rmi.RemoteException;

public class MyCalcImpl implements MyCalc {

    @Override
    public int add(int a, int b) throws RemoteException {
        return (a + b);
    }
}