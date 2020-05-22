@Entity
public class Products implements Serializable {
...
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idProductFK")
    private List<OrdersProducts> listOfOrdersProducts = new ArrayList<OrdersProducts>();
}