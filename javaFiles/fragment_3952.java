public class SiteMinderUserDetailsService extends PreAuthenticatedGrantedAuthoritiesUserDetailsService implements
        UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
        SiteMinderUserDetails userDetails = new SiteMinderUserDetails();
        userDetails.setUsername(arg0);      
        return userDetails;
    }

    @Override
    protected UserDetails createuserDetails(Authentication token, Collection<? extends GrantedAuthority> authorities) {
        return super.createuserDetails(token, authorities);
    }
}