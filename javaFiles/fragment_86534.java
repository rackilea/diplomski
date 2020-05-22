@Component(
    label = "sample service",
    description = "sample service"
)
@Service
public class ServiceImpl {
    @Reference
    private ResourceResolverFactory resolverFactory;

    public void getDocFromService(Map<String, String> params) {
        new Thread( new Runnable() {

           // security hole, fix later
           ResourceResolver resolver = resolverFactory.getAdministrativeResourceResolver(null);
           Session session = null;
           if (resolver != null) {
               session = resolver.adaptTo(Session.class);
               Node root = session.getRootNode();
               ...
           }
       }
    }
}