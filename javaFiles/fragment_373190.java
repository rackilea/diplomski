public class NotOnWeekendsModule extends AbstractModule {
  protected void configure() {
     bindInterceptor(any(),
         annotatedWith(NotOnWeekends.class),
         new WeekendBlocker(getProvider(Calendar.class)));
  }
}