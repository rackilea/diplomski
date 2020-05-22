public interface MyRepository<T, ID> extends JpaRepository<T, ID> {        
    public List<Event> findByTag(Tag t);
}

public class MyRepositoryImpl<T, ID> implements MyRepository<T, ID> {

    private Class<T> actualClass; // initialized in the constructor

    public List<Event> findByTag(Tag t) {
         // here you build the criteria using actualClass field, and execute it.
    }
}

public interface AaaaRepository extends MyRepository <Aaaa, Integer> {
    // other methods...
}