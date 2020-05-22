@Singleton
@Requires(beans = MongoClient.class)
@Replaces(MongoHealthIndicator.class)
public class MyMongoHealthIndicator implements HealthIndicator {

    @Override
    public Publisher<HealthResult> getResult() {
        return Publishers.just(buildStatus("mongodb"));
    }

    private HealthResult buildStatusUp(String name) {
        HealthResult.Builder builder = HealthResult.builder(name);
        builder.status(HealthStatus.UP);
        return builder.build();
    }
}