@Stateless
public class SomeService {

    @EJB
    private SomeService self; // Self-reference is perfectly fine.


    // Below example starts a new transaction for each item.

    public void foo(Iterable<Long> ids) {
        for (Long id : ids) {
            self.fooInNewTransaction(id);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void fooInNewTransaction(Long id) {
        // ...
    }


    // Below example fires an async thread in new transaction.

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void bar(Iterable<Long> ids) {
        for (Long id : ids) {
            self.fooAsynchronously(id);
        }
    }

    @Asynchronous
    public void fooAsynchronously(Long id) {
        // ...
    }

}