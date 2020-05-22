@Entity
public class Order {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinFormula("(SELECT of.id FROM order_flow of WHERE of.order_id = id OR of.order_id is null order by of.order_id desc LIMIT 1)")
    private OrderFlow orderFlow;
}