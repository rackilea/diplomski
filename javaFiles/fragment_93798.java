PathHandler path = Handlers.path(Handlers.redirect("/"))
    .addPrefixPath("/", manager.start());

final EncodingHandler handler = 
    new EncodingHandler(new ContentEncodingRepository()
      .addEncodingHandler("gzip", 
          new GzipEncodingProvider(), 50,
          Predicates.parse("max-content-size[5]")))
      .setNext(path);

// ...
Undertow server = builder.setHandler(handler).build();