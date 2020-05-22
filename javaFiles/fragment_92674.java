@Stateless(name="UserBean")
@EJB(name="app/SecurityService",
        beanInterface=SecurityServiceLocal.class)
public class UserBean implements UserRemote{

}