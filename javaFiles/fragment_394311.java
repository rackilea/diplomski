@ManagedBean
@RequestScoped
public class LoginBean {

    private String userName;
    private String password;

    @ManagedProperty
    private ReceiveClass receiveClass;

    public void forward() {
        receiveClass.dbc(this);
    }

    // Add/generate getters and setters.
}