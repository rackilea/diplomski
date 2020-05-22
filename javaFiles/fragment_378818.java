public class OnStartModule extends AbstractModule {
  @Override
  protected void configure() {    
    bind(BackgroundTasks.class).asEagerSingleton();
  }
}