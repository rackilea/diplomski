@Component
public class CustomAuthenticationProvider
implements AuthenticationProvider {

@Autowired
private ThirdPartyClient thirdPartyClient;

public void setAtpClient(ThirdPartyClient atpClient) {
    this.thirdPartyClient = atpClient;
}

@Override
public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();


    Request3rd requestTO = new AtpAuthenticateRequestDTO();
    requestTO.setPassword(password);
    requestTO.setUsername(username);
    Response3rd authenticate = this.thirdPartyClient.authenticate(requestTO);

    if (authenticate != null) {
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        Authentication auth = new UsernamePasswordAuthenticationToken(authenticate.getUsername(), password, grantedAuths);
        return auth;
    } else {
        return null;
    }
}

@Override
public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
}

}