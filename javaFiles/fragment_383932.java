public interface SomeInterface {
}

@Component
public class SomeImpl1 implements SomeInterface {}

@Component
public class SomeImpl2 implements SomeInterface {}

@Service
public сlass SampleBean {

     @Autowired
     private List<SomeInterface> beans;
}