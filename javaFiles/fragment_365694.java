import static akka.pattern.Patterns.pipe;
// ... 

Future<HttpResponse> response = Http.get(system)
  .singleRequest(HttpRequest.create("http://akka.io"), materializer);
pipe(response, context.dispatcher()).to(self);