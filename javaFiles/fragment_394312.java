@ManagedBean
@SessionScoped
public class ReceiveClass {

    public void dbc(LoginBean loginBean) {
        System.out.println(loginBean.getUserName());
    }

}