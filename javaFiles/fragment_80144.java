public class MyClass {

    private MyService service;

    @Autowired
    public MyClass(MyService service) {
        this.service = service;
    }

}