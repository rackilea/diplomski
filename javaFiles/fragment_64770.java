public class Test
{
  private StatusReporter rep;
  private IEventBroker broker;

  @Inject
  public Test(StatusReporter rep, IEventBroker broker)
  {
    this.rep = rep;
    this.broker = broker;
  }
}