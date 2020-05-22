@Stateless(name="UserBean")
@EJB(name="app/SecurityService",
        beanInterface=SecurityServiceLocal.class,
        beanName="SecurityServiceEnha")
public class UserBean implements UserRemote{

}