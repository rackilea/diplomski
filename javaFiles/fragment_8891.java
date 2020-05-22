@ManagedBean
@SessionScoped
public class UserSessionBean implements HttpSessionBindingListener {

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        for (File file : files) {
            file.delete();
        }
    }

    // ...
}