@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    BCryptPasswordEncoder encoder = passwordEncoder();
    User user = userRepository.findByUsername(username);
    if(user == null){
        throw new UsernameNotFoundException("User Name "+username +"Not Found");
    }
    return new org.springframework.security.core.userdetails.User(user.getUserName(),encoder.encode(user.getPassword()),getGrantedAuthorities(user));
}

@Bean
public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}