@Endpoint(id = "myhealth")
public class MyHealthEndpoint {

    @ReadOperation
    public MyHealth health() {
        Map<String, Object> details = new LinkedHashMap<>();
        details.put("MyStatus", "is happy");
        MyHealth health = new MyHealth();
        health.setDetails(details);

        return health;
    }
}