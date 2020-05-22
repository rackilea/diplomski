@Service
@Transactional
public class EmployeeService
{
    @Autowired
    private GenericDao<Absence>  absenceDao;
    @Autowired
    private GenericDao<Credit>   creditDao;
    @Autowired
    private GenericDao<Employee> employeeDao;


    public Absence getAbsenceObject()
    {
        return absenceDao.getObject();
    }

    public Credit getCreditObject()
    {
        return creditDao.getObject();
    }

    public Employee getEmployeeObject()
    {
        return employeeDao.getObject();
    }
}