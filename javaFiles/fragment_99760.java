@Component
public class Polling {

    private CommService commService;

    @Reference
    public void setCommService(CommService cs) {
        this.commService = cs;
    }

    public void someMethodThatUsesCommService() {
         sendPoll(cs);
         // ...
    }
}