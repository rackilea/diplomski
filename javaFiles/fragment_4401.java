@Controller
@RequestMapping("/DataOwnerReg")
public class DataOwnerRegController {

    private final DataService dataService;

    @Autowired
    public DataOwnerRegController(DataService DataService) {
      this.dataService=dataService;
    }

    @ModelAttribute
    public Owner owner() {
      return new Owner();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {        
        return "DataOwnerReg";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registeruser(@ModelAttribute("owner") Owner owner, BindingResult result){
        dataService.insertRow(owner);
        return "DataOwnerReg";
    }
}