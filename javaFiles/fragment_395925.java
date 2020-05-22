public void process(Message message) {
    JPAPlugin.startTx(false);
    boolean rollBack = false;
    try {
        // work with your models
        JPA.em().flush();
    } catch (RuntimeException e) {
        rollBack = true;
        // throw exception to prevent msg ACK, need to refine error handling :)
        throw e;
    } finally {
        JPAPlugin.closeTx(rollBack);
    }
}