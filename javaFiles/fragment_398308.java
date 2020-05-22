@Entity
public class MyEntity implements Serializable {    

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Version
    private Long version;

    //...
}