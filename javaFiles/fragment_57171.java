@Stateless
public class SomeService {

    @EJB
    private SomeService self;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void foo(Iterable<Long> ids) {
        for (Long id : ids) {
            self.foo(id);
        }
    }

    public void foo(Long id) {
        // ...
    }

}