public class AppEvent extends ScEvent {

    public interface AppEventConsumer 
    {
        void rescue(AppEvent e);
    }

    private static final Module KEY = Module.APP;
    private Action action;

    public AppEvent(Action action) { this.action = action; }