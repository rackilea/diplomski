public interface JPAProjection {
}

public interface UserRepository extends CrudRepository<UserAccount, Long> {
    <T extends JPAProjection > T getByUsername(String username, Class<? extends JPAProjection> projection);
}