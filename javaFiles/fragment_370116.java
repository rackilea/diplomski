@Service
public class StatusManagerServiceImpl implements StatusManagerService {
    @Autowired
    private PlatformTransactionManager transactionManager;

    public separateTransactionMethod() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                // Do something here that will be committed right away.
            }
        });
    }
}