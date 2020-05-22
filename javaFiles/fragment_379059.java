@Stateless
public class MyEjb{

    @PersistenceContext(unitName="primary")
    EntityManager em;

    public Foo find(long id){
        return em.find(Foo.class, id);
    }
}