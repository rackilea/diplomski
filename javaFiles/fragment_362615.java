public class LifeCycle
{
  @ProcessAdditions
  public void processAdditions(IEventBroker eventBroker, MApplication app, EModelService modelService)
  {
     MWindow window =(MWindow)modelService.find("uploadcenter.source.trimmedwindow.0", app);

     eventBroker.subscribe(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE, 
                          new AppStartupCompleteEventHandler(window));
  }


  private static class AppStartupCompleteEventHandler implements EventHandler
  {
    private MWindow theWindow;

    AppStartupCompleteEventHandler(MWindow window)
    {
       theWindow = window;
    }


    @Override
    public void handleEvent(final Event event)
    {
      theWindow.getContext().set(IWindowCloseHandler.class, handler);        
    }
  }
}