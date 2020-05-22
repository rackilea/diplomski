public class SampleServiceImpl implements SampleService {
  private MessagesApiCustom messages;

  @Inject
  public SampleServiceImpl(MessagesApiCustom messages){
     this.messages = messages;
  }

  private void doSomeStuff(){
    Strign message = messages.at("message.key")
  }
}