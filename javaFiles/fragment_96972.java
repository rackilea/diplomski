@Embeddable
public class ProjectEmbedded {
    private Long projectId;
    private String projectName;
}


@Entity
public class SubTask {
    private Long subTaskId;
    private String subTaskName;
    @Embedded
    private ProjectEmbedded project;
}