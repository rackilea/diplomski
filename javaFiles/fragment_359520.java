public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.role WHERE u.userName = (:userName)")
    public User findByUserNameAndFetchRoles(@Param("userName") String userName);

    @Query("FROM User u JOIN FETCH u.role")
    public List<User> getAllUsersAndFetchRoles(); // **query that you would use!**
}