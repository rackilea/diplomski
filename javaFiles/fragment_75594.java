public class AConnexAuthenticationProvider implements AuthenticationProvider {

    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

    static {
      AUTHORITIES.add(new GrantedAuthorityImpl("ROLE_USER"));
    }

    @Override
    public Authentication authenticate(Authentication auth)
            throws AuthenticationException {
        return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
    }

    @Override
    public boolean supports(Class<? extends Object> paramClass) {
        return true;
    }
}