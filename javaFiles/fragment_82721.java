public class AppContextInitializer implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

        @Override
        public void initialize(ConfigurableWebApplicationContext applicationContext) {
            Properties props;
            try {
                props = PropertiesLoaderUtils.loadAllProperties("/some/path");
                PropertiesPropertySource ps = new PropertiesPropertySource("profile", props);
                applicationContext.getEnvironment().getPropertySources().addFirst(ps);
            } catch (IOException e) {
                // handle error
            }
        }
    }