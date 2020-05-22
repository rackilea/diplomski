@Entity
public class Test implements Serializable {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

}