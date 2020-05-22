@Retry
@Transactional("chainedTransactionManager")
public void myServiceOperation() {
    if(workNotDone()) {
        doDatabaseTransactionWork();
    }
    sendMessagesToRabbit();
}