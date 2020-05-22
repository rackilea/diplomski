@Component
public class UserAccountDao implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Execute database query to retrieve the user details. 
        return <userDetails>;
}