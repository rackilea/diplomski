@Service
public class SampleBean {
   private final List<SomeInterface> beans;
   // I haven’t checked this with compiler, should work
    @Autowired // optional, if you have a single constructor, you can omit it
    public SampleBean(Optional<List<SomeInterface>> beans) {
       this.beans = beans.orElse(Collections.emptyList());   
    }
}