@Service (objectName = "jboss:custom=Name")
@Remote(ServiceOneRemote.class)
@Depends ({"jboss:service=someService"})
public class ServiceOne implements ServiceOneRemote, ServiceOneManagement
   {
    ...