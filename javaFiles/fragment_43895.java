@Entity
public class Clients implements Serializable {
...
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idClientFK")
    private List<Orders> listOfOrders = new ArrayList<Orders>();
}