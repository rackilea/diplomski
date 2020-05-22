//Import statement to import MessageContext class
import org.apache.axis2.context.MessageContext;

/*
* This method gets the client IP address using axis2 MessageContext 
*
* @return Client IP : String
*/
private String getClientIP () {

      return (String)(MessageContext.getCurrentMessageContext()).getProperty(MessageContext.REMOTE_ADDR);

}