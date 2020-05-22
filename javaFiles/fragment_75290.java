@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Component
public class FooListener {
    @EventListener(FooEvent.class)
    public void listen() {
         System.out.println("I'm listening. PS : I am "+this.toString());
    }
}