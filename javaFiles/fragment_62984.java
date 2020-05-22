@Component
public class ToBeTested implements Something {
    SomeClass theClass;

    @Autowired
    public ToBeTested(SomeClass theClass) {
        this.theClass = theClass;
    }    

    @Override
    public ReturnValue doSomeAction(Parameter theParam) {
        try {
            MyReturnValue myReturnValue = theClass.doSomething(
                    parameterOfTypeInputStream,
                    parameterOfTypeString
            );

        // other stuff

            return theParam;
        } catch (IOException e) {
            throw new RuntimeException("Oh no!");
        }
    }