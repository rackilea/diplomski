@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UserSpace{

    private File userRoot=....somehow set that on bean creation - eg at @PostConstruct
   .....other fields if needed
}