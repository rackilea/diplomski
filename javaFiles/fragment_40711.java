public interface MyService extends JpaRepository<Employee,Long> {

    @Query("select * from employee e where e.projectId = ?1")
    public List<Employee> getEmployeesWorkingOnAProject(String projectId) throws MyException;

}


@Component
public class ProjectServiceImpl implements ProjectService {

    private final MyService service;

    @Autowire // not necessary in spring 4.3 +
    public ProjectServiceImpl(MyService service) {
        this.service = service;
    }

    public List<Employee> getEmployeesWorkingOnAProject(String projectId) throws MyException {
         return service.getEmployeesWorkingOnAProject();
    }
}