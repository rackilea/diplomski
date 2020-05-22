@XmlRootElement
@Entity
@Table(name = "workbench_group_permissions")
public class WorkbenchGroupPermissionEntity extends BasicEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private WorkbenchPermissionEntity workbenchPermission;

    @ManyToOne
    @JoinTable(name = "workbench_group_permissions", joinColumns = 
       @JoinColumn(name = "workbench_groups_id"), inverseJoinColumns = 
       @JoinColumn(name = "workbenchgroupspermissions_id"))
    private WorkbenchGroupEntity workbenchGroup;