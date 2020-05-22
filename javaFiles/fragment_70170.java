public class MyInterceptor extends EmptyInterceptor {
.
.
.

private static ThreadLocal<Boolean> wasCommited = new ThreadLocal();

@Override
public void beforeTransactionCompletion(Transaction tx) {
    // not called for rollback
    wasCommited.set(Boolean.TRUE);
}


@Override
public void afterTransactionCompletion(Transaction tx) {

    if ( !Boolean.TRUE.equals(wasCommited.get()) ) {
        try {
           // handle transaction rolled back
        }
        finally {
            wasCommited.set(null);
        }
    }
}
}