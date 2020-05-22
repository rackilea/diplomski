import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Test
    public void test1() {
        //save new user in db:
        userDao.save(new User("Name1")); //in result in db 1 user
        //set savepoint:
        TransactionStatus status = platformTransactionManager.getTransaction(
                new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        //do changes in db:
        userDao.save(new User("Name2")); //in result in db 2 users
        //roll back to savepoint:
        platformTransactionManager.rollback(status);
        userDao.findAll(); //in result in db 1 user
    }