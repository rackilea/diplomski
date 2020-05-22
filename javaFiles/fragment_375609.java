@ServiceScan
public class S3CloudCOnfig extends AbstractCloudConfig {

    @Autowired
    @Bean
    public S3Repository s3Repository(final MyService service) {

        // Cloud service configuration.
        S3Properties properties = null;
        try {
        } catch (...) {
            // No service is configured...
        }

        S3Repository result = null;
        if (properties) {
            result = new S3Repository(properties);
            service.setObjectStorage(service);
        }
        return result;
    }
}