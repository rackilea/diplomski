@Component
public class FooAssembler{
       @PersistenceContext
       private EntityManager em;

       public Foo toFoo(Long barId){
          return new Foo(em.getReference(Bar.class, barId))
       }
}