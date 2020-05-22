@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public List<Employee> getEmployees(@RequestBody EmployeeIdsRequest idsRequest) {
        return employeeRepository.findAllById(idsRequest.getIds());
    }

    static class EmployeeIdsRequest {

        private List<Integer> ids;

        public List<Integer> getIds() {
            return ids;
        }

    }

}