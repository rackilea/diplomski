//skipped lines    
import org.springframework.data.domain.Example
//skipped lines
interface EmployeeRepository extends JpaRepository<Employee, EmployeeKey>{
    List<Employee> findAll(Example<Employee> employee);
}