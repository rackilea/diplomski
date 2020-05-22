@Bean
public ErrorWebExceptionHandler myExceptionHandler() {
  return new MyWebExceptionHandler();
}

public class MyWebExceptionHandler implements ErrorWebExceptionHandler {
  @Override
  public Mono<Void> handle(
    ServerWebExchange exchange, Throwable ex) {
    byte[] bytes = "Some text".getBytes(StandardCharsets.UTF_8);
    DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
    return exchange.getResponse().writeWith(Flux.just(buffer));
  }
}