@Entity
public class Trade {

    @Id
    @Column(name = "ID")
    private Long tradeTag;

    @ElementCollection
    @CollectionTable(name = "charges", joinColumns = @JoinColumn(name="ID"))
    @OrderColumn
    private List<Charge> charges;

}