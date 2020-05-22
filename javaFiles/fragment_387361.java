@Configuration
public class ESConfig {

    @Bean
    public EntityMapper getEntityMapper() {
        return new CustomEntityMapper();
    }

    @Bean
    @Primary
    public ElasticsearchOperations elasticsearchTemplate(final JestClient jestClient,
            final ElasticsearchConverter elasticsearchConverter,
            final SimpleElasticsearchMappingContext simpleElasticsearchMappingContext, EntityMapper mapper) {
        return new JestElasticsearchTemplate(jestClient, elasticsearchConverter,
                new DefaultJestResultsMapper(simpleElasticsearchMappingContext, mapper));
    }

    public class CustomEntityMapper implements EntityMapper {

        private final ObjectMapper objectMapper;

        public CustomEntityMapper() {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            objectMapper.registerModule(new CustomGeoModule());
            objectMapper.registerModule(new JavaTimeModule());
        }

        @Override
        public String mapToString(Object object) throws IOException {
            return objectMapper.writeValueAsString(object);
        }

        @Override
        public <T> T mapToObject(String source, Class<T> clazz) throws IOException {
            return objectMapper.readValue(source, clazz);
        }

    }
}