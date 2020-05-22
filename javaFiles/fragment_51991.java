public class RedisCache<T> implements GetCachedOrLoad<T> {

  private final Function<String, Flux<String>> getFromCache;
  private final BiConsumer<String, String> loadToCache;
  private final Gson gson;

  public RedisCache(Gson gson, RedisReactiveCommands<String, String> redisCommands) {
    this.getFromCache = key -> redisCommands.lrange(key, 0, -1);
    this.loadToCache = redisCommands::lpush;
    this.gson = gson;
  }

  @Override
  public Flux<T> getCachedOrLoad(final String key, Flux<T> loader, Class<? extends T> clazz) {
    final Flux<T> cacheResults = getFromCache.apply(key)
      .map(json -> gson.fromJson(json, clazz));
    return cacheResults.switchIfEmpty(
      loader.doOnNext(value -> loadToCache.accept(key, gson.toJson(value))));
  }
}