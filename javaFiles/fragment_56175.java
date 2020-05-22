import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.client.MuleClient;

public class MyCustomComponent implements Callable {  


    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
      MuleClient muleClient = eventContext.getMuleContext().getClient();
      muleClient.dispatch("jms://my.queue", "Message Payload", null);        
    }
}