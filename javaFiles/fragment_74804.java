@Controller
public class SampleControler {

    @Autowired
    private Checker checker;

    @Autowired
    private Environment environment;

    @RequestMapping("/monitoring")
    String home(Model map)
    {
        try {
            map.addAttribute("donnee", checker.run(environment.getProperty("yourParam1", "defaultValue"));

            return "index" ;
        }catch (Exception e) {
            return "error";
        }
    }
}