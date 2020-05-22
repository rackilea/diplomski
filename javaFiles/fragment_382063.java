import play.cache.*;
import play.mvc.*;

import javax.inject.Inject;

public class Application extends Controller {

    private CacheApi cache;

    @Inject
    public Application(CacheApi cache) {
        this.cache = cache;
    }

    // ...
}