public class ShippingAddressDataSerializer extends JsonSerializer<ShippingAddressData> {

    @Autowired
    private CalculatedSettingsService calculatedSettingsService;

    public ShippingAddressDataSerializer() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    // ...

}