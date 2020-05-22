@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long taskId;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "task", cascade = CascadeType.ALL)
    private List<TaskRelated> relatedTasks = new ArrayList<TaskRelated>();
}

@Entity
public class TaskRelated {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long taskRelatedId;

    @OneToOne
    @JoinColumn(name="relatedTaskId", insertable=false, updatable=false)
    private Task relatedTask;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="taskId", insertable=false, updatable=false)
    private Task task;
}