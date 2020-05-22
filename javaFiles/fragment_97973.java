@Controller
public class MyController {

    @Autowired
    private MyServiceLayer myService;

    // Put annotation for getting it in Json
    public List<SomeObject> getAllSomeObjectsInJson() {
        return myService.getAllSomeObjects();
    }

    // Put annotation for getting the view data
    public ModelAndView getAllSomeObjectsView() {
       // Return your ModelAndView here.
    }
}