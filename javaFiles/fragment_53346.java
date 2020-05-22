public class HostExtractor extends Controller {

    @Before
    public static void extractHost() {
       // Code to read from request headers and extract whatever you need here.
       String host = 'Your Code Here'
       renderArgs.put("hostname", host);
    }
}