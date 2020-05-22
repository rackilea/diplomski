public class ConnectionClass implements java.io.Serializable {

 }

public interface SekelatonInterface extends Remote ,java.io.Serializable{

public Login getTestClass()throws RemoteException;

public String test() throws RemoteException;

public List<Login> getConnection() throws RemoteException;

public void sayHitoServer(String messages) throws RemoteException;

}
public class SkeletonInterfaceImpl extends UnicastRemoteObject implements      SekelatonInterface,Serializable {

  //implement all your skeleton methods
 }

 //this to change result set into model class to transefer it to client

public class Login {

private int Id;

private String Username;

private String Password;

public Login() {

}

public int getId() {
    return Id;
}

public void setId(int Id) {
    this.Id = Id;
}

public String getUsername() {
    return Username;
}

public void setUsername(String Username) {
    this.Username = Username;
}

public String getPassword() {
    return Password;
}

public void setPassword(String Password) {
    this.Password = Password;
}

public Login(ResultSet resultset){
    try{
    // resultset.next();
  Id = resultset.getInt("LoginId");
  Username =resultset.getString("Uname");
  Password = resultset.getString("Password");
          }
    catch(Exception ex){
    JOptionPane.showMessageDialog(null, "Error Setting Up Login"+ex.getMessage());

     }
   }
}