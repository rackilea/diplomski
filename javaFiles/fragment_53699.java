imports...

@Configuration
public class AppServiceLoader {
    @Bean(name = "propLoader")
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();

        String mainConfigPath = StringUtils.isNotEmpty(System.getenv("CONFIG_LOCATION"))
                ? System.getenv("CONFIG_LOCATION") : System.getProperties().getProperty("CONFIG_LOCATION");

        File configFolder = new File(mainConfigPath);

        if(configFolder.isDirectory()) {
            FilenameFilter ff = new FilenameFilter() {

                @Override
                public boolean accept(File file, String string) {
                    return string.endsWith(".properties");
                }
            };
            File[] listFiles = configFolder.listFiles(ff);
            Resource[] resources = new Resource[listFiles.length];
            for (int i = 0; i < listFiles.length; i++) {
                if(listFiles[i].isFile()) {
                    resources[i] = new FileSystemResource(listFiles[i]);
                }
            }
            pspc.setLocations(resources);
        }

        pspc.setIgnoreUnresolvablePlaceholders(true);
        return pspc;

    }
}