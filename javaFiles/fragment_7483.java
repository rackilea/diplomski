@WebService
@Stateless
public class Test {

     @EJB
     FirstBean myFirstBean;//first bean containing the Async method.

    /**
     * Can be used in futher methods to follow
     * the running web service method
     */
    private Future<String> myAsyncResult;

    @WebMethod
    @WebResult(name = "hello")
    public String sayHello(@WebParam(name = "timeout_in_seconds") long timeout)
    {
        myAsyncResult = myFirstBean.sayHelloAsync();
        String myResult = "Service is still running";
        if(timeout>0)
        {
            try {
                myResult= myAsyncResult.get(timeout, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                myResult="InterruptedException occured";
            } catch (ExecutionException e) {
                myResult="ExecutionException occured";
            } catch (TimeoutException e) {
                myResult="The timeout value "+timeout+" was reached."+ 
                                 " The Service is still running.";
            }
        }
        return myResult;
    }
}