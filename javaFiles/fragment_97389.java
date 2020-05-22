import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Foo {
  private HTTPClient myHTTPClient = new HTTPClient("http://my_host.com");  //java ws rs http client
  private static final ForkJoinPool pool = new ForkJoinPool(1000);

  private interface Handler<REQ, RES> {
    RES work(REQ req);
  }

  private <REQ, RES> CompletableFuture<RES> getAsync(REQ req, Handler<REQ, RES> handler) {
    CompletableFuture<RES> future = CompletableFuture.supplyAsync(() -> {
      return handler.work(req);
    });

    return future;
  }

  public RouteCostResponse getRouteCost(Point sources, List<Point> destinations) {
    Map<String, Request> requests = new HashMap<>();

// create request bodies and keep track of request id's
    for (Point destination : destinations) {
      requests.put(destination.getId(), new RouteCostRequest(source, destination))
    }

    //create futures
    ConcurrentMap<String, CompletableFuture<RouteCost>> futures = requests.entrySet().stream()
    .collect(Collectors.toConcurrentMap(
        entry -> entry.getKey(),
        entry -> getAsync(entry.getValue(), route -> myHTTPClient.getRoute(route)))
    ));

    //retrieve results
    ConcurrentMap<String, RouteCost> result = futures.entrySet().stream()
    .collect(Collectors.toConcurrentMap(
        entry -> entry.getKey(),
        entry -> entry.getValue().join()
    ));

    RouteCostResponse response = new RouteCostResponse(result);

    return response;
  }
}