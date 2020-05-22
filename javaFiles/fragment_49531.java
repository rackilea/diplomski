@XmlRootElement
@Entity
@Table(name = "workbench_groups")
public class WorkbenchGroupEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy="workbenchGroup", cascade = CascadeType.ALL)
    private List<WorkbenchGroupPermissionEntity> workbenchGroupPermissions;