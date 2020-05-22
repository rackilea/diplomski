public class MyController {

    private MyService myService;

    public MyController(MyService aService) { // constructor based injection
        this.myService = aService;
    }

    public void setMyService(MySerice aService) { // setter based injection
        this.myService = aService;
    }

    @Autowired
    public void setMyService(MyService aService) { // autowired by Spring
        this.myService = aService;
    }

    @RequestMapping("/blah")
    public String someAction()
    {
        // do something here
        myService.foo();

        return "someView";
    }
}