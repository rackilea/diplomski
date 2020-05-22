public class ExampleHandler1 implements RequestHandler<String, String> {
    @Override
    public String handleRequest(String input, Context context) {
        // would preferably use some other way to generate json
        return "{\"speech\": \"hello theres\"}";
    }
}