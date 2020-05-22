@UrlBinding("/show-order-{order=}.html")
public class OrderAction implements ActionBean {
    private ActionBeanContext context;
    private Order order;

    public ActionBeanContext getContext() {
        return context;
    }

    public void setContext(ActionBeanContext context) {
        this.context = context;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution(“/WEB-INF/jsp/order.jsp”);
    }
}