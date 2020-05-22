@RestController
public class GreetingController {
  @GetMapping("/greeting")
  public Mono<Greeting> getGreeting(ServerHttpRequest serverHttpRequest) {
    return Mono.just(new Greeting("greeting", serverHttpRequest.getURI().toString()));
  }
}