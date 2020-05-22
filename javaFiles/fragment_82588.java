public class MyPresenter {
    @Inject
    MyInteractor interactor;

    public MyPresenter(MyView view) {
        // Perform your injection. Depends on your dagger implementation, e.g.
        OBJECTGRAPH.inject(this)
    }
}