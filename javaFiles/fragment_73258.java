@Entity
@Table(name="client")
public class Client {

    [....]
    @JsonIgnoreProperties("client")
    private List<Car> carList;
    [...]
}