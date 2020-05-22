@Configuration
@PropertySource("classpath:sql/find-all-sample-native-query.xml")
public class SampleFindAllConfig {
    @Value("${sample.findAll}")
    private String findAllQuery;

    @Bean
    public String findAllSampleNativeQuery() {
        return findAllQuery;
    }
}