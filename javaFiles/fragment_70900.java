@Entity
@Table(name = "PROFOLDERSYS_JOIN")

public class ProjectFileSystem implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int foldersysid;

private int proclassid;

private int projectid;

private String projectName;

private String folderName;

public ProjectFileSystem() {

}

public ProjectFileSystem(int proclassid, int projectid,
        String projectName, String folderName) {
    this.proclassid = proclassid;
    this.projectid = projectid;
    this.projectName = projectName;
    this.folderName = folderName;
}


// getters and setters
}