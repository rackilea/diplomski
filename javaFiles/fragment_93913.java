public class MyServerResource extends ServerResource {
    @Get
    public String test() {
        String ua = getRequest().getClientInfo().getAgent();
        System.out.println("[server resource] ua = " + ua);
        return "test";
    }
}