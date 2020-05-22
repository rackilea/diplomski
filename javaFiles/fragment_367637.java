@Service
static class UserService {
    private final UserDao userDao;

    UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional // <---
    public Set<String> findUserRoles() {
        final List<User> users = this.userDao.findAll();
        return users.stream()
                .flatMap(user -> user.roles.stream())
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}