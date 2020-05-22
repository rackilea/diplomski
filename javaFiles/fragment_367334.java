@Repository
public class EmployeeDataDaoImpl  {


    @PersistenceContext
    private EntityManager entityManger;


    public List<Employee> findAllEmployee(){
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}