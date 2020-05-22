@Service
public class EmployeeServiceImpl extends EmployeeService {

    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "900"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10") })
    public void getEmployee(int employeeId) {
        System.out.println("Getting Employee details for " + employeeId + ", threadLocalUtil : " + threadLocalUtil.getDataFromThreadLocalMap("EMPLOYEE_ID"));
        String response = restTemplate.exchange("http://localhost:8011/findEmployeeDetails/{employeeid}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }, employeeId).getBody();

        threadLocalUtil.addDataToThreadLocalMap("Response", response);
    }

    @Autowired
    RestTemplate restTemplate;
}