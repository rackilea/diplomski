@Component
public class SomeClass{

    @Autowired
    private Clock clock;

    public LocalDate someMethod(){
         return LocalDate.now(clock);
    }
}