final Http http = Http.get(system);
final ActorMaterializer materializer = ActorMaterializer.create(system);

final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = createRoute(system).flow(system, materializer);
final CompletionStage<ServerBinding> binding = http.bindAndHandle(routeFlow,
    ConnectHttp.toHost("localhost", 8080), materializer);