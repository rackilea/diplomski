public class PersistenceManagerModule extends AbstractModule {
  @Override 
  protected void configure() {
  }

  @Provides @RequestScoped
  PersistenceManager providePersistenceManager(HttpServletRequest request) {
    return (PersistenceManager) request.getAttribute("pm");
  }
}