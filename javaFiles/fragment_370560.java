@Entity
@Table(name = "gauge_category")
public class GaugeCategory {

    @Id
    @GeneratedValue
    private Integer id;

    @Id
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    // ...

}