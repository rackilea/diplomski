@Component
public class CustomerFilterConfig {
    private static final Set<String> ignorableFieldNames = new HashSet<>();

    static {
        ignorableFieldNames.add("phoneNumber");
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
        FilterProvider filters = simpleFilterProvider.addFilter("customerFilter", SimpleBeanPropertyFilter.serializeAllExcept(ignorableFieldNames));
        objectMapper.setFilterProvider(filters);

        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }    
}