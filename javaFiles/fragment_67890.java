@Entity
@Table(name="TAB_CUSTOMER")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CUSTOMER_ID", precision=0)
    private Long customerId = null;

   ...
}