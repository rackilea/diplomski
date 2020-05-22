@Repository
public interface UserDao extends JpaRepository<User, Long> {

   @Query("select u, p from User u, Post p where u.id =:userId and p.id =:postId")
   List<Object[]> findUserAndPost(@Param("userId") Long userId, @Param("postId") Long postId);

}