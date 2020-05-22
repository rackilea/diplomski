public class CustomEventBus extends EventBus {
  //If version 18 or bellow
  @Override
  void dispatch(Object event, EventSubscriber wrapper) {
    try {
        wrapper.handleEvent(event);
    } catch (InvocationTargetException cause) {
        Throwables.propagate(Throwables.getRootCause(cause));
    }
  }
  //If version 19
  @Override
  public void handleSubscriberException(Throwable e, SubscriberExceptionContext context) {
    Throwables.propagate(Throwables.getRootCause(e));
  }
}