@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper objectMapper(final CalculatedSettingsService calculatedSettingsService) {
        final ObjectMapper mapper = new ObjectMapper();

        final SimpleModule module = new SimpleModule();
        module.addSerializer(ShippingAddressData.class, new ShippingAddressDataSerializer(calculatedSettingsService));
        mapper.registerModule(module);

        return mapper;
    }

}