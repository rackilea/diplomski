@ServerEndpoint("/serverpush")
public class ContratoEndpoint {

    @Inject
    private Storage storage;

    @OnMessage
    @RequestContextOperation
    public String handleMessage(String message){

        // Here the @RequestScoped bean is valid thanks to the @RequestContextOperation InterceptorBinding
        storage.yourMethod();
        ....
    }

}