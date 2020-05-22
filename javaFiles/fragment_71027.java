public interface Login {

    void login(String name, String password);
 }

public class LoginImpl implements Login {

    @Audit(handler = LoginHandler.class)
    public void login(String name, String password) {
        System.out.println("login");
    }

}