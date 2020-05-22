@Entity
@Table(name = "order_details")
public class OrderDetails {

    private int orderId;
    private String orderName;
    @ManyToMany(mappedBy = "orders")
    private Collection<ProductDetails> products = new ArrayList();