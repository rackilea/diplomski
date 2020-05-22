public class LauncherVerticle extends AbstractVerticle {
@Override
public void start(Future<Void> startFuture) throws Exception {
        ConfigStoreOptions fileStore = new ConfigStoreOptions()
                .setType("file")
                .setFormat("properties")
                .setConfig(new JsonObject().put("path", System.getProperty("vertex.config.path")));

        ConfigRetrieverOptions options = new ConfigRetrieverOptions().addStore(fileStore);
        ConfigRetriever configRetriever = ConfigRetriever.create(vertx, options);

        DeploymentOptions deploymentOptions = new DeploymentOptions();
        configRetriever.rxGetConfig().subscribe(s -> {
                    deploymentOptions.setConfig(s);
                    vertx.deployVerticle(AnotherVerticle.class.getName(),
                            deploymentOptions,
                            result -> startFuture.complete()
                    );
                },
                startFuture::fail
        );
    }
}