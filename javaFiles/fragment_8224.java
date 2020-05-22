import com.google.inject.persist.Transactional;
import javax.persistence.EntityManager; 

public class MyTest {
        @Inject EntityManager em; 

        @Test
        @Transactional 
        public void createNewPerson() {
                em.persist(new Person(...)); 
        } 
}