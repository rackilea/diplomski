@Controller
@RequestMapping("/foo")
public class Foo {
    @Autowired
    private Something something;

    @RequestMapping("/list")
    public String foo() {
       something.someMethod();
       bar();
       return "view"
    }

    private void bar() {
        // something
    }
}