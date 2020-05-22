public interface UserProjection {
    Long getId();
    String getFirstname();
    Integer getAge();
}

public interface UserRepository extends CrudRepository<User, Long> {
    List<UserProjection> findById(Long id);
}