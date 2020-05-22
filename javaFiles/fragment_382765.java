@Configurable
public class MyClass {
        @Autowired
        @Qualifier("some_bean")
        private SomeBean sb;
    }