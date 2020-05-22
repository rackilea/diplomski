public class DelegatingUserDetailsService implements UserDetailsService {
    private final List<UserDetailsService> userDetailsServices;

    public DelegatingUserDetailsService(
            List<UserDetailsService> userDetailsServices) {
        this.userDetailsServices = userDetailsServices;
    }

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        RuntimeException last = null;
        for(UserDetailsService uds : userDetailsServices) {
            try {
                return uds.loadUserByUsername(username);
            } catch(RuntimeException error) {
                last = error;
            }
        }
        throw last;
    }
}