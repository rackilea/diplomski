@Service
public class CustomPreAuthUserDetailsService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    @Override
    public final UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) {
    ...    
    }
}