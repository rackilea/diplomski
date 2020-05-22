abstract class BaseDAO<T> {
  Class<?> entityClass;

  BaseDAO() {
    //this is based on the link I posted above but basically uses the actual concrete class 
    //(subclass determined by getClass() ) to extract the generic types and 
    //since we only have one we get the first one from the returned list
    entityClass = ReflectionHelper.getTypes(getClass(), BaseDAO.class).get(0); 
  }

  public T getEntity(Object id) { 
  ...
  }
}

abstract class TranslatableDAO<T extends TranslatableEntity> extends BaseDAO<T> {
...
}

//Users are not translatable
class UserDAO extends BaseDAO<User> {
...
}

//Products are translatable, i.e. Product extends TranslatableEntity
class ProductDAO extends TranslatableDAO<Product> {
...
}