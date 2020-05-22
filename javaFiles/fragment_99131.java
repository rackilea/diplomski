public class MyFactory {

    @Autowired
    private A a;

    private final OriginalFactory originalFactory;

    public MyFactory(OriginalFactory originalFactory) {
        this.originalFactory=originalFactory;
    }

    public CreateObject getInstance() {

        CreatedObject createdObject = originalFactory.getInstance();
        createdObject.setA(a);

        return createdObject;
    }
}