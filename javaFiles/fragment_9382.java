@PostContextCreate
public void postContextCreate(IEclipseContext context)
{
  context.set(IEventLoopAdvisor.class, new EventLoopAdvisor(context));

  ...
}

class EventLoopAdvisor implements IEventLoopAdvisor
{
  private final IEclipseContext _appContext;

  EventLoopAdvisor(IEclipseContext appContext)
  {
    super();

    _appContext = appContext;
  }

  @Override
  public void eventLoopIdle(final Display display)
  {
    display.sleep();
  }

  @Override
  public void eventLoopException(final Throwable exception)
  {
    // Report error
  }
}