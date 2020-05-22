@ConfigurationProperties(prefix = "endpoints.mongo", ignoreUnknownFields =     true)
@Component
public class MongoDBHealthCheckEndPoint extends    AbstractEndpoint<Map<String, String>> 
 {

@Inject
MongoTemplate mongoTemplate;


private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

private static final Map<String, String> UP = new HashMap<String, String>() {{
    put("mongo.status", "UP");
}};

private static final Map<String, String> DOWN = new HashMap<String, String>() {{
    put("mongo.status", "DOWN");
}};


public MongoDBHealthCheckEndPoint() {
    super("mongo", false);
}

public MongoDBHealthCheckEndPoint(Map<String, ? extends Object> mongo) {
    super("mongo", false);
}

public Map<String, String> invoke() {
    try {
        return (new MongoHealthIndicator(mongoTemplate).health().getStatus().equals(Status.UP)) ? UP : DOWN;
    } catch (Exception e) {
        log.error("mongo database is down", e);
        return DOWN;
    }
}