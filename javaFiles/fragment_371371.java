public class CustomApplicationLoader extends GuiceApplicationLoader {

    @Override
    public GuiceApplicationBuilder builder(ApplicationLoader.Context context) {
        final Environment environment = context.environment();
        GuiceApplicationBuilder builder = initialBuilder.in(environment);
        Configuration config = context.initialConfiguration();
        if (environment.isTest()) {
            config = merge("test.conf", config);
            builder = builder.bindings(new TestModule());
        } else if (environment.isDev()) {
            config = merge("dev.conf", config);
            builder = builder.bindings(new DevModule());
        } else if (environment.isProd()) {
            config = merge("prod.conf", config);
            builder = builder.bindings(new DevModule());
        } else {
            throw new IllegalStateException("No such mode.");
        }
        return builder.in(environment).loadConfig(config);
    }

    private Configuration merge(String configName, Configuration currentConfig) {
        return new Configuration(currentConfig.getWrappedConfiguration().$plus$plus(new play.api.Configuration(ConfigFactory.load(configName))));
    }
}