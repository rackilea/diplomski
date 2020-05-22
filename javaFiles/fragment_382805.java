@MessageDriven(activationConfig = {   
@ActivationConfigProperty( propertyName = "destinationType", propertyValue = "javax.jms.Queue" ),   
@ActivationConfigProperty( propertyName = "destination", propertyValue = "queue/myQueue"),
@ActivationConfigProperty( propertyName = "maxSession", propertyValue = "20")  
})
public class MyBean implements MessageListener {
  public void onMessage(Message m) {
    // do something with message
  }
}