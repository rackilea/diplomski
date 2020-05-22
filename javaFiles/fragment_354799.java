@Transactional(readOnly=true)
@Override
public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

    com.mkyong.users.model.User user = userDao.findByUserName(username);
    List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

    return buildUserForAuthentication(user, authorities);

}

// Converts com.mkyong.users.model.User user to
// org.springframework.security.core.userdetails.User
private User buildUserForAuthentication(com.mkyong.users.model.User user, List<GrantedAuthority> authorities) {
    return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
}