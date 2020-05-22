@Stateless
@Local(X.class)
public class SLSBX implements X {

    @EJB Y y;

    @TransactionAttribute(TransactionAttributeType.REQUIRED) // start a new transaction to do work
    public void sampleMethod() {
         // suspends the existing transaction on invoking Y.anotherSampleMethod()
         Y.anotherSampleMethod();
         // continue doing work in the current transaction. Work done in anotherSampleMethod() would have either committed or rolled back.
    }
}

@Stateless
@Local(Y.class)
public class SLSBY implements Y {
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW) // Suspends the existing transaction and creates a new transaction that terminates on method return
    public void anotherSampleMethod() {
        // do some stuff
    }
}