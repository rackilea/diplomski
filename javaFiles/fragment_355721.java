public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List users = getSession().createCriteria(User.class).add(Restrictions.eq("username", username)).list();
    if (users == null || users.isEmpty()) {
        throw new UsernameNotFoundException("user '" + username + "' not found...");
    } else {
        return (UserDetails) users.get(0);
    }
}