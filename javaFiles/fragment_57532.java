@Retryable(StaleStateException.class)
@Transactional
public void performDatabaseActions() {
    //Database updates here that may cause an optimistic locking failure 
    //when the transaction closes
}