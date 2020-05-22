/**
 * Interface for methods you want to implement manually.
 */
interface UserRepositoryCustom {
  Optional<User> findByLogin(String login);
}

/**
 * Implementation of exactly these methods.
 */
class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

  private static final QUser USER = QUser.user;

  @Override
  public Optional<User> findByLogin(String login) {

    return Optional.ofNullable(
      from(USER).
      where(
        USER.deleter.isNull(),
        USER.locked.isFalse(), 
        USER.login.equalsIgnoreCase(login)).
      singleResult(USER));
  }
}

/**
 * The main repository interface extending the custom one so that the manually
 * implemented methods get "pulled" into the API.
 */
public interface UserRepository extends UserRepositoryCustom, 
  CrudRepository<User, Long> { … }