public class CompositeListener implements EventListener {
    public void handle(Object event) {
        if (event instanceof PriceUpdate) {
            ///
        } else if (event instanceof OrderEvent) {
            ///
        }
    }
}