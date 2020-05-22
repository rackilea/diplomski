@Entity
public class Orders implements Serializable {
...
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idOrderFK")
    private List<OrdersProducts> listOfProductsInOrder = new ArrayList<OrdersProducts>();
    @JoinColumn (referencedColumnName = "idclient")
    @ManyToOne
    private Clients idClientFK;
}