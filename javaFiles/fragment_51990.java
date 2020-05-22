public class PersistedObjectRepository {

  private final GetCachedOrLoad<PersistedObject> getCachedOrLoad;

  public PersistedObjectRepository(final GetCachedOrLoad<PersistedObject> getCachedOrLoad) {
    this.getCachedOrLoad = getCachedOrLoad;
  }

  public Flux<PersistedObject> queryPersistedObject(final String key) {
    return getCachedOrLoad.getCachedOrLoad(key, queryMongoDB(key), PersistedObject.class);
  }

  private Flux<PersistedObject> queryMongoDB(String key) {
    // use reactivemongo api to retrieve Flux<PersistedObject>
  }
}