public class MyObjectRepositoryCustomImpl implements MyObjectRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    public final List<MyObject> findByNameWithWeirdOrdering(String name) {
        Query query = query(where("name").is(name));
        query.sort().on("whatever", Order.ASC);
        return entityManager.find(query, MyObject.class);
    }
}