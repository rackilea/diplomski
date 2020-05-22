@FeignClient(name = DUMMY_FEIGN_CLIENT_NAME)
@CircuitBreaker(name = DUMMY_FEIGN_CLIENT_NAME)
public interface DummyFeignClient {

    String DUMMY_FEIGN_CLIENT_NAME = "dummyFeignClient";

    @GetMapping(path = "/api/{param}")
    void doSomething(@PathVariable(name = "param") String param);
}