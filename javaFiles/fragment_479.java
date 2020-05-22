package renansouzaproperties;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

import java.util.List;

@Controller("/demo")
public class DemoController {

    private List<Server> serverList;

    public DemoController(List<Server> serverList) {
        this.serverList = serverList;
    }

    @Get("/")
    public HttpStatus index() {
        for(Server server: serverList) {
            System.out.println(server);
        }
        return HttpStatus.OK;
    }
}