@With(OurLogger.class)
public class OurController extends Controller {

  public CompletionStage<Result> ourAction() {
    return CompletableFuture.supplyAsync(()->...);
  }
}