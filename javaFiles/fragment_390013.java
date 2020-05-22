public class UserDetailsExtendedService implements UserDetailsService {
    @Autowired
    private UsersDAO usersDao;

    private UserDetails prepare(com.data.User user) {
        boolean enabled = user.getState().equals(UserState.Active);

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (UserRole r: /*CALL TO WEB-SERVICE*/) {
          authorities.add(new GrantedAuthorityImpl(r.getName()));
        }

        return new UserDetails(user.getId(), user.getEmail(), user.getPassword(), user.getNickname(), user.getPosition(), user.getAvatar(), user.getCommunicationLanguage().getCode(), 
            user.getNotificationChannel(), user.getPartnerId(), enabled, enabled, enabled, enabled, authorities);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String email)
            throws UsernameNotFoundException, DataAccessException, HibernateException {
        com.data.User user = usersDao.getByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException(email);

        return prepare(user);
    }
}