public interface UserRepository extends CrudRepository<User, Integer> {


@Modifying
@Transactional
@Query(value = "INSERT INTO users(email, password, name) VALUES (:#{#user.email},:#{#user.firstname},:#{#user.name})", nativeQuery = true)
void insertUserToUsers(@Param("user") User user);
}