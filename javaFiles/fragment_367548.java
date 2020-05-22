@Controller
@RequestMapping(path = "/demo")
public class PropertyController {
    @Autowired
    private MyService myService;

    public PropertyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(path = "/map")
    public @ResponseBody
    HashMap<String,String> get() {
        return myService.getPropertiesMap();
    }
}