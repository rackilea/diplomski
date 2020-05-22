public class ServiceImpl implements Service {

  private final MyDao dao;

  @Inject
  public ServiceImpl(final MyDao dao) {
    this.dao = dao;
  }

  public List<String> getAllObject() {
    // Some processing
    return dao.getAllObject();
  }
}