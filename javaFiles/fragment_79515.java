public class MyTestInjectedClass {

    @Inject
    MyClassUsingMyInterface mMyClassUsingMyInterface;

    void onStart() {
        DaggerMyComponent.create().inject(this);
    }
}