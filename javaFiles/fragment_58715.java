@Repository
public interface UserRepository extends MongoRepository<User,String> {

   @org.springframework.data.mongodb.repository.Query(value = "{ 'bookletSignups': { $elemMatch: { 'bookletId' : ?0 } }}")
   List<User> findByBookletId(String id);

}