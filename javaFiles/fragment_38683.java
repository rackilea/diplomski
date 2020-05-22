interface FoobarRepositoryCustom{
    List<Foobar> findFoobarsByDate(Date date);
}

interface FoobarRepository extends CrudRepository<Foobar, Long>, FoobarRepositoryCustom

public class FoobarRespoitoryImpl implements FoobarRepositoryCustom{
    @PersistenceContext private EntityManager em;


    public List<Foobar> findFoobarsByDate(Date date) {
    String sql = "select fb from Foobar fb where createdDate > :date";
    ...
    return query.getResultList();
    }
}