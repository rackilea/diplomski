public boolean test () throws javax.script.ScriptException {
    try {
        transaction.begin();
        ...
        transaction.commit();
        return true;
    } catch (javax.script.ScriptException ex) {
        transaction.rollback();
        throw ex;
    }
}