public interface UserRepository extends JpaRepository<User, Long> {

       @Query("select u from User u where u.firstname like %?1")
       List<User> findAll();

       @Query("select u from User u where u.id == %?1")
       User findById(String id);
    }