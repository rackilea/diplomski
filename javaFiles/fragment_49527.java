@Component
public class MyClass {
    @Autowired
    @Qualifier("myFriends")
    private List<String> myFriends= new ArrayList<String>();
    //Getters and setters
}