@MappedSuperClass
class BaseEntity {
  @Id
  private int id;
}

@Entity
class UserEnity extends BaseEntity {
  //user stuff like name
}

class BaseDAO<T extends BaseEntity> {
  public T findById(int id) { 
    ... 
  }
  //other generic CRUD methods
}

@Stateless
class UserDAO extends BaseDAO<UserEntity> {
  //additional user specific methods
}