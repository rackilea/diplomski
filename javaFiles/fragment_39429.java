public abstract class Controller<T extends View> {
    protected T view;

    public Controller(T v) {
        view = v;
    }

    protected void render() {
        data();
        view.setData(data);
        view.render();
        listeners();
        if (display)
            view.open();
    }
    protected void data() {}

    protected void listeners() {}
}

public class AboutController extends Controller<AboutView> {

    public AboutController() {
        super(new AboutView());
        super.render();
    }

    public void doSomething() {
        view.getAboutStuff();
    }
}