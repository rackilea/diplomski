public TransactionResult test () {
    TransactionResult result;
    try {
        transaction.begin();
        ...
        transaction.commit();
        result = new TransactionResult();
    } catch (javax.script.ScriptException ex) {
        transaction.rollback();
        result = new TransactionResult(ex.getMessage());
    }
    return result;
}