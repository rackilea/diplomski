public class MyRetry {
    @Autowired
    private RetryTemplate retryTemplate;
    public void myMethod() throws Exception {
        retryTemplate.execute(
            new RetryCallback<Void, Exception>() {
                @Override
                public Void doWithRetry(RetryContext context) throws Exception {
                    System.out.println("Attempt...");
                    throw new Exception();
                }
            },
            new RecoveryCallback<Void>() {
                @Override
                public Void recover(RetryContext context){
                    System.out.println("Recovering...");
                    return null;
                }
            }
        );
    }
}