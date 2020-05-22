@Entity
@Table(name = "quoteOrderHistory")
public class QuoteOrderHistory {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @Column(name = "storeNumber")
    private int storeNumber;

    @Column(name = "invoiceNumber")
    private String invoiceNumber;

    @Column(name = "quoteSaleDate")
    private Date quoteSaleDate;

    @Column(name="orderTotal")
    private BigDecimal orderTotal;

    @Column(name="orderHistoryDate")
    private Timestamp orderHistoryDate;

    // Constructor, getters, setters

}