@Entity
@Table(name= "Car")
public class Car {

    [.....]
    @JsonIgnoreProperties("carList")
    private Client client;
    [...]
}