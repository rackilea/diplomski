@Value // It's Lombok annotation
public class UserDto {
    Long id;
    String firstname;
    Integer age;
}

public interface UserRepository extends CrudRepository<User, Long> {
    List<UserProjection> findById(Long id);
    List<UserDto> getById(Long id);
}