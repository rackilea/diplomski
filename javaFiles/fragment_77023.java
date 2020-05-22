public class AppHandler extends ScHandler
{
    public AppHandler(Action action) { super(action); }

    @Override
    public void onClick(ClickEvent event) 
    { 
         EventBus.get().fire(new AppEvent(action)); 
    }