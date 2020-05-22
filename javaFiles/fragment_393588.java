class DAO<T> {
   //   protected String entityClass = "";
   public T findById(int id) {

      return (T)EntityFromDatabase; // how to do this?
   }
}
class UserDAO extends DAO<User> {
   //protected String entityClass = "User";
}
class ProductDAO extends DAO<Product> {
   //protected String entityClass = "Product";
}
class User extends Entity {
   public int id;
   public String name;
}