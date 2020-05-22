@RestController
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/employe")
    public List<Employe> get(){
        return employeService.get();
     }
 }