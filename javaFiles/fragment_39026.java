@Component
public class ListenerClass {

  @EventListener
  public void handleFooEvent(Foo fooEvent) {...}

  @EventListener
  public void handleBarEvent(Bar barEvent) {...}

}