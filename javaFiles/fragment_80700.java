package greeting.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.function.Function;

@Controller("/")
public class HelloController {

    @Inject
    Function<String, String> stringService;

    @Autowired
    private ApplicationContext applicationContext;

    @Get(uri = "/hello/{name}", produces = MediaType.TEXT_PLAIN)
    public Single<String> hello(String name) {
        Function<String, String> service =  applicationContext.getBean(Function.class);
        return Single.just("Hello " + name + " with " + stringService.apply(name)
                + " and " + service.apply(name));
    }
}