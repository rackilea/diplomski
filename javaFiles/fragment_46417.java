@Autowired
private TransactionTemplate transactionTemplate;

transactionTemplate.execute(new TransactionCallbackWithoutResult() {
    @Override
    public void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
            repo1.save(myEntity);
            repo2.save(anotherEntity);
    });