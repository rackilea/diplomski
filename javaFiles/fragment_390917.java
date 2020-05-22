public class CustomFilter implements Filter {
  private final Cache<String, ClientRequest> cache;

  public CustomFilter(Cache<String, ClientRequest> cache) {
    this.cache = Objects.requireNonNull(cache);
  }