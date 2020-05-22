@Component
public class CallerService{

    private MyAsyncService myAsyncService;

    @Autowired
    public CallerService(MyAsyncService myAsyncService){
        this.myAsyncService = myAsyncService;
    }

    public void myMethod(){
        CompletableFuture<ResultClass> result1 = myService.findUser("PivotalSoftware");
        CompletableFuture<ResultClass> result2 = gitHubLookupService.findUser("CloudFoundry");        

        CompletableFuture.allOf(result1, result2).join();

        ResultClass finalResult1 = result1.get();
        ResultClass finalResult2 = result2.get();
    }
}