@Inject
private Event<ProdEvent> prodEvent;

public void someMethod() {
   ProdEvent pe = new ProdEvent()
   // set some data on ProdEvent
   prodEvent.fire(pe);
}