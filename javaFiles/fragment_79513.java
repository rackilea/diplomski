@MyScope // be sure to add scopes in your class if you use constructor injection!
public class MyClassUsingMyInterface {
    private MyInterface mMyInterface;

    @Inject
    public MyClassUsingMyInterface(MyInterface myInterface) {
        mMyInterface = myInterface;
    }
}