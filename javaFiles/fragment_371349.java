@Component
public class AuthorityUtils {

//org.springframework.security.authentication.AuthenticationManager
@Autowired
private AuthenticationManager authenticationManager;

public void loginDirectly(String email, String password) {
    UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(email, password);
    Authentication authenticatedUser = authenticationManager.authenticate(loginToken);
    SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}