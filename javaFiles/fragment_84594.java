@Component
public class MyClass {

    @Autowired
    private StudentJDBCTemplate studentJDBCTemplate;

    // here you can implement a method and use studentJDBCTemplate it's already injected by spring.
}