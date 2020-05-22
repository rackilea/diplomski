import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import javax.inject.Inject;
import akka.stream.Materializer;
import play.mvc.*;


public class GlobalHeaders extends Filter {

    @Inject
    public GlobalHeaders(Materializer mat) {
        super(mat);
    }

    @Override
    public CompletionStage<Result> apply(Function<Http.RequestHeader, CompletionStage<Result>> nextFilter,Http.RequestHeader requestHeader) {

        return nextFilter.apply(requestHeader).thenApply(result -> {
            return result.withHeader("Access-Control-Allow-Origin", "*")
                    .withHeader("Allow", "*")
                    .withHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS")
                    .withHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        });
    }
}