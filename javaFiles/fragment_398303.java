@Named("bean")
@RequestScoped
public class LoginBean {

public String loadLoggedUser() {
    if ( userId != null ) {
        this.user = user.findById(userId);
        return null;
    }
    return "failure";
}
}