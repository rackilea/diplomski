public boolean test () throws MyGreatException {
    try {
        transaction.begin();
        ...
        transaction.commit();
        return true;
    } catch (javax.script.ScriptException ex) {
        transaction.rollback();
        throw new MyGreatException(ex);
    }
}