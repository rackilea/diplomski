@Dependant
public class Bean1 implements Serializable {

    private @Inject @PathDir String pathDir; // inject pathDir here instead of in Bean2

    private Bean2 bean2; // without inject, created in init()

    @PostConstruct
    public void init() {
        bean2 = new Bean2("param1", "param2");
        bean2.setPathDir(pathDir);  // set injected value manually
    }

    public void someMethod() {
        bean2.foo(); // here bean2.pathDir should be already initialized via setPathDir in init() method above
    }
}