@Component
public class AuthProviderForDinosaur implements AuthenticationProvider {


  @Override
  public Authentication authenticate ( Authentication authentication ) throws AuthenticationException {
    List<GrantedAuthority> grantedAuths = new ArrayList<>();
    grantedAuths.add( new SimpleGrantedAuthority( "ROLE_USER" ) );
    return new UsernamePasswordAuthenticationToken( authentication.getName(), authentication.getCredentials(), grantedAuths );
  }

  @Override
  public boolean supports ( Class<? extends Object> authentication ) {
    return ( UsernamePasswordAuthenticationToken.class.isAssignableFrom( authentication ) );
  }
}