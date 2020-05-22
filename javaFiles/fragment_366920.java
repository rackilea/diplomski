@Controller
public class SessionUnsubscribeListener implements ApplicationListener<SessionUnsubscribeEvent> {

   @Override
   public void onApplicationEvent(SessionUnsubscribeEvent event) {
       GenericMessage message = (GenericMessage) event.getMessage();

       String simpDestination = (String) message.getHeaders().get("simpDestination");

       if ("/topic/service".equals(simpDestination)) {
           // do stuff
       }
   }
}