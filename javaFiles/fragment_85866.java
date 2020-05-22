@Inject
private HibernateSessionManager manager;

public void doSomeWork(Entity entity) {
  try {
    session.delete(entity);
    manager.commit();
  } catch (Exception e) {
    manager.abort();
  }
}