@With(HostExtractor.class)
public class MyController extends Controller {

    public static void homepage() {
        String hostname = renderArgs.get("host", String.class);
        // Do whatever logic you need to render the page here.
    }
}