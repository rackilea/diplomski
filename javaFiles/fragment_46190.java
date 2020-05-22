import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import akka.util.ByteString;
import play.filters.csrf.CSRFFilter;
import play.libs.streams.Accumulator;
import play.mvc.EssentialAction;
import play.mvc.EssentialFilter;
import play.mvc.Result;
import play.routing.Router;

public class MaybeCsrfFilter extends EssentialFilter {

    private final EssentialFilter csrfFilter;

    private final List<String> applyCsrf = new LinkedList<>();

    @Inject
    public MaybeCsrfFilter(final CSRFFilter csrfFilter) {
        this.csrfFilter = csrfFilter.asJava();

        // alternatively, define the inclusion/exclusion list in the config and inject Configuration to obtain it
        applyCsrf.add("/foo/bar");
        applyCsrf.add("/view/$foo<[^/]+>/$bar<[^/]+>");
    }

    @Override
    public EssentialAction apply(final EssentialAction next) {
        return EssentialAction.of(request -> {
            final Accumulator<ByteString, Result> accumulator;
            final String currentRoute = request.tags().get(Router.Tags.ROUTE_PATTERN);
            if (applyCsrf.contains(currentRoute)) {
                accumulator = csrfFilter.apply(next).apply(request);
            } else {
                accumulator = next.apply(request);
            }
            return accumulator;
        });
    }
}