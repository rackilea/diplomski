public interface UserName {
    ...
}

@Component 
@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
public class UsernameImpl implements UserName { 
    private String username; 
    ...
}