package controllers;

import java.io.IOException;
import java.io.InputStream;
import javax.inject.Inject;
import com.fasterxml.jackson.databind.JsonNode;
import play.Environment;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class SomeController extends Controller {

    private final Environment env;

    @Inject
    public SomeController(final Environment env) {
        // the environment is used to access local files
        this.env = env;
    }

    public Result index() {
        try (InputStream is = env.resourceAsStream("/foo.json")) {
            final JsonNode json = Json.parse(is);
            return ok(json);
        } catch (IOException e) {
            return internalServerError("Something went wrong");
        }
    }
}