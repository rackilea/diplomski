public class TransactionalService {

    @Transactional("account")
    public void setSomethingInAccount() { ... }

    @Transactional("businessData")
    public void doSomethingInBusinessData() { ... }
}