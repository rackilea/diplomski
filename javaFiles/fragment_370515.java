@NoRepositoryBean
public class ExtendedJpaRepositoryImpl<T>
             extends SimpleJpaRepository<T, Long>
             implements ExtendedJpaRepository<T> {
  ...

  public T findByFilter(Filter<T> t) { ... }

  public T findByField(String fieldName, Object fieldValue) { ... }
}