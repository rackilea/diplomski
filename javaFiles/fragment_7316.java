public abstract class AbstractCommand<R> implements Command<R> {

    private Window window;

    public AbstractCommand(Window window) {
        this.window = window;
    }

    public Window getWindow() {
        return window;
    }
}