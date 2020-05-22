@Stateless
public class WebListenerSessionService {

 //Use Instance since http session are dynamic.
 @Inject
 private Instance<HttpSession> httpSession;

 @Produces
 @Dependent
 public SessionDependentService sessionDependentService(){
   //use session to lookup existing service or produce a new one.
 }

}