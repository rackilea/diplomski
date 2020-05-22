Undertow.builder().addHttpListener(8080, "0.0.0.0")
    .setHandler(Handlers.path()

        // REST API path
        .addPrefixPath("/api", Handlers.routing()
            .get("/customers", exchange -> {...})
            .delete("/customers/{customerId}", exchange -> {...})
            .setFallbackHandler(exchange -> {...}))

        // Redirect root path to /static to serve the index.html by default
        .addExactPath("/", Handlers.redirect("/static"))

        // Serve all static files from a folder
        .addPrefixPath("/static", new ResourceHandler(
            new PathResourceManager(Paths.get("/path/to/www/"), 100))
            .setWelcomeFiles("index.html"))

    ).build().start();