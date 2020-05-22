public final class MyUserDetailsService implements UserDetailsService {
    private final UsersDao usersDao;

    @Autowired
    public UserDetailsServiceImpl(final UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {      
            UserEntity user = usersDao.getUserByOpenIdIdentifier(username);
            if (user == null) {
                    // there is no such user in our db, we could here throw
                    // an Exception instead then the user would also be deuthenticated 
                    return new User(username, "", new ArrayList<GrantedAuthority>());
            }

            //here we are granting to users roles based on values from db
            final Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(user.getUserType().toString()));

            final UserDetails result = new User(username, "", authorities);

            return result;
    }
}