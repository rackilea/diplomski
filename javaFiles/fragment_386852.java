@RestController
public class HealthCheckerController {

    @Autowired
    private InstanceRepository instanceRepository;

    public HealthCheckerController(InstanceRepository instanceRepository) {
        this.instanceRepository = instanceRepository;
    }

    @RequestMapping(value = "/healthchecker", method = RequestMethod.GET)
    @ResponseBody
    public List<Instance> findAll() {
        return this.instanceRepository.findAll();
    }
}