@Name("com.organization.product.Notification")
@Label("Notification")
public class Notification extends jdk.jfr.Event {
   @TransitionTo
   @Label ("Receiver");
   Thread receiver;
}