public class RepositoryFacade {

    private final UserRepository<? extends User> repository;

    public RepositoryFacade(UserRepository<? extends User> repository) {
        this.repository = repository;
    }

    public List<User> findAll(final UserCriteria userCriteria, final PageDetails pageDetails) {
        return repository.findAll(userCriteria, pageDetails)
                .stream()
                .collect(Collectors.toList());
    }

    public User findByEmail(final String email) {
        return repository.findByEmail(email);
    }
}

public RepositoryFacade getJpaUserFacade() {
    return new RepositoryFacade(new JpaUserRepository());
}