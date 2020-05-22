@Configuration
public class PrototypeFactory {
    @Bean
    @Scope(Prototype)
    public YourInterfaceOrClass createInstance() {
         return new YourInterfaceOrClass();
    }
}

public class ThreadLocalItemProcessor implements ItemProcessor {

    @Autowired
    private PrototypeFactory prototypeFactory;

    private ThreadLocal<ItemProcessor> threadProcessor = ThreadLocal.withInitial(this::processorCreator);

    @Override
    public Object process(Object item) throws Exception {
        return threadProcessor.get().process(item);
    }

    //ItemProcessor directly implemented as lambda
    // this will only be called once per working thread
    private Object process(Object input) {

       // will produce a valid SpringBean instance
       YourInterfaceOrClass inst = prototypeFactory.createInstance();

       ... process the input           
    }
}