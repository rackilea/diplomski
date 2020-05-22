public class AToBMapperImpl implements AToBMapper {
  public static final long EXPIRE_TIME_IN_SECONDS =
      TimeUnit.SECONDS.convert(1, TimeUnit.HOURS); // or whatever
  private final SomeDAO dao;
  private final ConcurrentMap<String, String> cache;
  private final Stopwatch stopwatch;

  public AToBMapperImpl(SomeDAO dao) {
    this.dao = dao;
    stopwatch = new Stopwatch();
    cache = new MapMaker().concurrencyLevel(2).makeMap();
  }

  @Override
  public synchronized String getBForA(final String a) {
    // if the map is not initialized, initialize it with the data
    if (!stopwatch.isRunning()) {
      cache.putAll(getNewCacheContents());
      stopwatch.start();
    }

    // if the map is expired, refresh all the data in the map
    if (stopwatch.elapsedTime(TimeUnit.SECONDS) >= EXPIRE_TIME_IN_SECONDS) {
      cache.clear();
      cache.putAll(getNewCacheContents());
      stopwatch.reset();
    }

    // return the mapped String for A
    // (if there is no mapping for A, return the "DEFAULT")
    return cache.containsKey(a) ? cache.get(a) : new String(DEFAULT_B_NAME);
  }

  private Map<String, String> getNewCacheContents() {
    return getTheData(Arrays.asList("keys", "you", "want", "to", "load"));
  }

  private Map<String, String> getTheData(List<String> listOfB) {
    return dao.getAToBMapping(listOfB);
  }
}