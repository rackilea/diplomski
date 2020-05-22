public class AppPresenter extends Subscriber implements AppEventConsumer, 
                                                        ConsoleEventConsumer
{
    public interface Display 
    {
        public void openDrawer(String text);
        public void closeDrawer();
    }

    private Display display;

    public AppPresenter(Display display)
    {
        this.display = display;
        EventBus.get().subscribe(this, new Module[]{Module.APP, Module.CONSOLE});
    }

    @Override
    public void rescue(ScEvent e) 
    {
        if (e instanceof AppEvent)
            rescue((AppEvent) e);
        else if (e instanceof ConsoleEvent)
            rescue((ConsoleEvent) e);
    }
}