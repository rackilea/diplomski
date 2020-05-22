public class CustomComponent implements Callable {
  public Object onCall(MuleEventContext eventContext) throws Exception {
    //Get at the payload by eventContext.getMessage().getPayload()
    return eventContext.getMessage();
  }
}