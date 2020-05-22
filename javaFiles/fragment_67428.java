@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Override
    @Cacheable(value = "EMPLOYEE_", key = "#id", cacheManager= "guavaCacheManager")
    public Employee getEmployee(int id) {
        return new Employee(id, "A");
    }

}