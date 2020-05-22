import java.sql.DriverManager;
import java.rmi.RemoteException;

public class UserDao {
    DriverManager driverManager = null;

    public void service() throws RemoteException {
        if (true) {
            throw new RemoteException();
        }
    }
}