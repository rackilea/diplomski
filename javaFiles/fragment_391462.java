@ManagedBean
@ViewScoped
public class LoginBean {
    private boolean loginEnabled;

    public LoginBean() {
        loginEnabled = true;
    }

    //getters and setters...

    //this method will return void, so the page will be refreshed with the new
    //loginEnabled value. this time the components inside "login" panelGrid won't be rendered
    //but "passRecovery" panelGrid components will.
    public void showPassRecovery() {
        loginEnabled = false;
    }
}