@Entity
@Table(name="Order")
@XmlRootElement(name="Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    @Column(name="Id")
    public int Id;

    @Column(name="DateOf")
    public java.util.Date DateOf;

    @Column(name="Description")
    public String Description;

    @OneToMany(cascade=CascadeType.REMOVE, mappedBy="order")
    public List<LineItem> Items;
}

@Entity
@Table(name="LineItem")
public class LineItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    @Column(name="Id")
    public int Id;

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="OrderId", referencedColumnName="Id")
    public Order order;
}