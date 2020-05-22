@Entity
@Table(name="TB_ORDER")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private String orderNumber;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}