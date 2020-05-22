@ApplicationScoped

public class JsonService {

@Inject
@ConfigProperty(name = "yourapikey.apikey")
private String apikey;

private Client client;
private WebTarget target;

@PostConstruct
protected void init() {
    client = ClientBuilder.newClient();
    //your query params
    target = client.target(
            "YOUR API URL").queryParam("param1", "10")
            .queryParam("param2", "json")
            .queryParam("param3", "metric")
            .queryParam("paramN", apikey)
            ;
}

public TransactionResponse getTransaction(String type) {
// the parameter would be one of your type of request( the one you want to order )
    return target.queryParam("q", type)
            .request(MediaType.APPLICATION_JSON)
            .get(TransactionResponse.class);
} }