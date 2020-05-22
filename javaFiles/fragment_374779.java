@Entity
public class Executive {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Executive> parentList = new ArrayList<Executive>();

    private String full_name;

}