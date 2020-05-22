@Entity
@Table(name = "product_details")
public class ProductDetails {

    private int productId;
    private String productName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "order_product", 
        joinColumns = { @JoinColumn(name = "productId") }, 
        inverseJoinColumns = { @JoinColumn(name = "orderId") }
    )
    private Collection<OrderDetails> orders = new ArrayList();

    [...]