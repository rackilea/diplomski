@Entity
public class Order implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer total;

    public String getName() {
        return name;
    }

    public Integer getTotal() {
        return total;
    }   
}