@Entity
@Table(name = "project")
public class Project {
@GeneratedValue(generator = "idIncrementor")
@GenericGenerator(name = "idIncrementor", strategy = "increment")
@Id
private Long id;

@Column(name = "name")
private String name;

@Column(name = "descriptions")
private String descriptions;

@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinTable(name = "project_has_task_plan",
        joinColumns = {@JoinColumn(name = "project_id")},
        inverseJoinColumns = {@JoinColumn(name = "task_plan_id")})
private Set<TaskPlan> taskPlans;