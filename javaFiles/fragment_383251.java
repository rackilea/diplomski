public class MyServerResource extends ServerResource {
    @Get
    public String test() throws Exception {
        return "test";
    }
}