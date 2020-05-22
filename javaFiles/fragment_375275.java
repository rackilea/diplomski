package web;

import spark.Service;
import spark.staticfiles.StaticFilesConfiguration;

public class ServerExample {

    public ServerExample() {
        Service service = Service.ignite();
        service.port(1234);

        // All other filters first
        service.before((request, response) -> { /* Authentication filter */ });
        service.before("/admin.html", (request, response) ->
                service.halt(401, "Nothing to see here"));
        service.before((request, response) -> { /* Some other filter */ });

        // Static files filter is LAST
        StaticFilesConfiguration staticHandler = new StaticFilesConfiguration();
        staticHandler.configure("/public");
        service.before((request, response) ->
                staticHandler.consume(request.raw(), response.raw()));

        // All your routes (are belong to us)
        service.get("/", (req, res) -> "Hello world");
        service.get("/health", (req, res) -> "Peachy");
    }

    public static void main(String[] args) {
        new ServerExample();
    }
}