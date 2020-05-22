@Root(name = "order_history")
public class OrderHistory {

    @Element(name = "id", required = false)
    public Integer ID;

    @Element(name = "id_order_state")
    public Integer StateID;

    @Element(name = "id_order")
    public Integer OrderID;
}