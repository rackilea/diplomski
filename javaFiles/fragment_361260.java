@Entity
     public class Employee 
     {
          @Id
          @Column(name="ID")
          private long id;
          ...
          @OneToMany...
          private List<ManagerReportProject> managerReportProjects;
          ...

          /*
          YOU DON'T NEED THIS ANYMORE:
          @ManyToMany
          @JoinTable(
              name="EMP_PROJ",
              joinColumns={@JoinColumn(name="EMP_ID", referencedColumnName="ID")},
              inverseJoinColumns={@JoinColumn(name="PROJ_ID", referencedColumnName="ID")})
          private List<Project> projects;

           */

       @Transient
       public List<Project> getProjects()
       {
          List<Project> projects = new ArrayList<Project>();
          for(ManagerReportProject managerReportProject: managerReportProjects)
          {
             projects.add(managerReportProject.getProject());
          }
          return projects;
       }
     ...
    }