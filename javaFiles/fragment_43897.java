@Entity
public class OrdersProducts implements Serializable {
...
    @JoinColumn (referencedColumnName = "idorderproduct")
    @ManyToOne
    private Products idProductFK;
    @JoinColumn (referencedColumnName = "idorder")
    @ManyToOne
    private Orders idOrderFK;
}