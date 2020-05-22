public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equalsIgnoreCase(username)) {
        return User.builder()
            .username(username)
            // This should contain the hashed password for the requested user
            .password("$2a$10$T5viXrOTIkraRe2mZPyZH.MAqKaR6x38L.rbmRp53yQ8R/cFrJkda")
            // If you don't need roles, just provide a default one, eg. "USER"
            .roles("USER", "ADMIN")
            .build();
    } else {
        // Throw this exception if the user was not found
        throw new UsernameNotFoundException("User not found");
    }
}