@FunctionalInterface
public interface TransactionRunnable {
    void runTransactionCode(EntityManager em);
}

public void runInNewTransaction(TransactionRunnable code) {
    try(Transaction tx = persistence.createTransaction()){
        code.runTransactionCode(persistence.getEntityManager());
        tx.commit();
    }
}

public void foo(Object bar, EntityManager em) { /*...*/ }
public void baz(String str, EntityManager em) { /*...*/ }