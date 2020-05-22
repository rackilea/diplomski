@Entity
public class Manager {
  @Id
  @Column(name="ID")
  private long id;
  ...
  @OneToMany...
  private List<ManagerReportProject> managerReportProjects;
  ...
}