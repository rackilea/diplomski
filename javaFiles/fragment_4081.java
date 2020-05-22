@Service
public class A {

    @Inject
    private B b;

    @Inject
    private C c;

    void method() {
        System.out.println("A's method called");
        b.method();
        c.method();

    }
}