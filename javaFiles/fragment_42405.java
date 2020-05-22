@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   

       // load user data from repository
       String password = ...
       boolean enabled = ...
       // ...
       UserDetails user = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
       return user;     
    }   
}