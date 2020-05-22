// valid for Akka Http 1.0 (experimental), APIs may change slightly still
final ActorSystem system = ActorSystem.create();
final ActorMaterializer materializer = ActorMaterializer.create(system);

final Future<HttpResponse> responseFuture =
  Http.get(system)
    .singleRequest(HttpRequest.create("http://akka.io"), materializer);