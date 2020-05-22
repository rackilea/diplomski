import javax.xml.bind.*;

public class CommodityValidator extends Marshaller.Listener implements ValidationEventHandler {

    private Order order;

    @Override
    public void beforeMarshal(Object source) {
        if(source instanceof Order) {
            // If we are marshalling an Order Store It
            order = (Order) source;
        }
    }

    @Override
    public boolean handleEvent(ValidationEvent event) {
        if(event.getLocator().getObject() instanceof Commodity) {
            // If the Error was Caused by a Commodity Object Remove it from the Order
            order.setCommodity(null);
            return true;
        }
        return false;
    }

}