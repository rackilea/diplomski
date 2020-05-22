@Entity
@Table(name = "tbl_estimate")
public class Estimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estimate")
    private Integer id ;

    @JoinColumn(name = "estimate_id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();     

    ...
}