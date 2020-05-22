import static akka.http.javadsl.server.PathMatchers.*;

return route(
  path(segment("hello").slash(segment("world")), () ->
    get(() ->
     complete("<h1>Say hello to akka-http</h1>")
    )
);