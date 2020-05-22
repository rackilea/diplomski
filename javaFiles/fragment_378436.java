public class UserDetailsImpl implements UserDetails {

    private Collection<GrantedAuthority> authorities = new  ArrayList<>();

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}