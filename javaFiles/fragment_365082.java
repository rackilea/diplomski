Observable vertice1EndStream = vertx.eventBus()
    .<JsonObject>consumer("vertice1_end")
    .bodyStream()
    .toObservable();

Observable vertice2EndStream = vertx.eventBus()
    .<JsonObject>consumer("vertice2_end")
    .bodyStream()
    .toObservable()

Observable bothVerticesEndStream = Observable.zip(vertice1EndStream, vertice2EndStream, (vertice1, vertice1) -> new Object());

vertx.eventBus()
    .<JsonObject>consumer("address")
    .bodyStream()
    .toObservable()
    .takeUntil(bothVerticesEndStream)
    .reduce(new JsonArray(), JsonArray::add)
    .subscribe(j -> System.out.println(j.toString()));