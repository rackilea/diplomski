@Name("com.organization.product.Notification")
@Label("Notification")
public class Notification extends jdk.jfr.Event {
   @TransitionFrom
   @Label ("Notifier");
   Thread notifier;
}