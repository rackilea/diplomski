public interface employeeService{

    Employee save(Employee employee);

    public <S extends User> List<S> saveAll(Iterable<S> entites);



}

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

   @Override
    public List<Employee> saveAll(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }

}