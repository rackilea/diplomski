@Entity
@Table(name="customer_product")
@NamedQuery(name="CustomerProduct.findAll", query="SELECT c FROM CustomerProduct c")
public class CustomerProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Column(name="customer_id")
    private Integer customerId;

    @Column(name="product_id")
    private Integer productId;