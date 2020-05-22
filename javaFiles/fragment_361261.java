@Entity
@Table(name= "EMP_PROJ")
public class ManagerReportProject{
  @Id
  @Column(name="ID")
  private long id;

//manager report columns
  private Date startDate;
  private Date endDate;
  performance, etc. 

  @ManyToOne...
  private Manager manager;

  ...
  @ManyToOne...
  private Employee employee;

  @ManyToOne...
  private Project project;

  ...
}