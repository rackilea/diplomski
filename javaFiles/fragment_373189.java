public class NotOnWeekendsModule extends AbstractModule {
  protected void configure() {
    MethodInterceptor interceptor = new WeekendBlocker();
    requestInjection(interceptor);
    bindInterceptor(any(), annotatedWith(NotOnWeekends.class), interceptor);
  }
}