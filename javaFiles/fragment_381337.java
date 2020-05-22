@Controller
public class MyController {

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    private final MyService myService;

    @GetMapping("/myPage")
    public String doIt() {
       myService.myBusinessLogic();
       return "myPage";
    }  
}