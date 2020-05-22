@Controller("/index.html")
public class IndexController {
    @Autowired
    private DataService dataService;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap modelMap) {
        modelMap.put(dataService.getDataAsList());
        return "index";
    }
}