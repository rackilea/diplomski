@RepositoryDefinition(domainClass = User.class, idClass = Integer.class)
public interface UserRepository {
    @Query("from User u join u.userRoles where u.id = ?1")
    User findOne(Integer id);
       ...
}